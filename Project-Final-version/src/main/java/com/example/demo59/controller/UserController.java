package com.example.demo59.controller;

import com.example.demo59.entity.*;
import com.example.demo59.service.UserService;
import com.example.demo59.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //登录成功之后的欢迎界面
    @RequestMapping("/welcomeUser")
    public String welcome(HttpServletRequest request, Model model) {
        Users users = (Users) request.getSession().getAttribute("user");
        if (users == null) {
            return "redirect:/user/logInUser";
        }
        model.addAttribute("userName", users.getUserName());
        return "lr/welcomeUser";
    }

    //用户注册界面
    @GetMapping("/register")
    public String registerPage() {
        return "lr/register";
    }

    //用户登录界面
    @GetMapping("/logInUser")
    public String list() {
        return "lr/loginUser";
    }

    //登出操作，导航到/logIn页面去
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("/user/logInUser");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid RegisterForm registerForm, BindingResult result, RedirectAttributes attributes) {
        attributes.addFlashAttribute("userName", registerForm.getUserName());
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            attributes.addFlashAttribute("errorMsg", errors.get(0).getDefaultMessage());
            return "redirect:/user/register";
        } else {
            if (registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
                if (userService.findUserByUsername(registerForm.getUserName()) != null) {
                    attributes.addFlashAttribute("errorMsg", "this username has been registered");
                    return "redirect:/user/register";
                }
                Users users = new Users();
                users.setUserName(registerForm.getUserName());
                users.setPhoneNumber(registerForm.getPhoneNumber());
                users.setIdCardNum(registerForm.getIdCardNum());
                users.setPassword(MD5Util.generatePassword(registerForm.getPassword()));
                userService.insertUser(users);
                attributes.addFlashAttribute("userName", registerForm.getUserName());
                return "redirect:/user/logInUser";
            } else {
                attributes.addFlashAttribute("errorMsg", "The two passwords are not the same.");
                return "redirect:/user/register";
            }
        }
    }

    @PostMapping("/logInUser")
    public String Userlogin(@Valid LogInform logInform,
                            BindingResult result,
                            RedirectAttributes attributes,
                            HttpServletRequest request) {

        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                if (error.getDefaultMessage().equals("Username shouldn't be null")) {
                    attributes.addFlashAttribute("errorMsg_0",
                            errors.get(0).getDefaultMessage());
                } else {
                    attributes.addFlashAttribute("errorMsg_1",
                            errors.get(0).getDefaultMessage());
                }
            }
            return "redirect:/user/logInUser";
        } else {
            Users login = new Users();
            login.setUserName(logInform.getUserName());
            login.setPassword(MD5Util.generatePassword(logInform.getPassword()));
            Users user = userService.findExistUserByUsrnameAndPasswd(login);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                return "redirect:/user/welcomeUser";
            }
            attributes.addFlashAttribute("errorMsg",
                    "the username or password is wrong");
            return "redirect:/user/logInUser";
        }
    }

    //-----------------------------------------------------------------------------------------
    @RequestMapping("/getOrder")
    public String order(HttpServletRequest request, Model model, @RequestParam("orderId") Integer orderId) {
        Users users = (Users) request.getSession().getAttribute("user");
        if (users == null) {
            return "redirect:/user/logInUser";
        }
        List<OrdersDetails> a = userService.getOrdersByNameAndOrderId(users.getUserName(), orderId);
        model.addAttribute("userName", users.getUserName());
        model.addAttribute("orderList", a);
        return "lr/orderInfo";
    }

    //---------------------------------------------------------------------------------------------
    @RequestMapping("/getStaStaInfo")
    public String getStaStaInfo(Model model,
                                @RequestParam("s1") String station1,
                                @RequestParam("s2") String station2,
                                @RequestParam("d") Date date
    ) {
        List<BetweenStationsInfo> list = userService.findTicketsBetweenStations(station1, station2, date);
//        list.sort(Comparator.comparing(BetweenStationsInfo::getTicketPrice));
        model.addAttribute("infoList", list);
        model.addAttribute("date", date);
        return "lr/stastaInfo";
    }

    @PostMapping("/getSSInfo")
    public String getStaskip(Model model, @ModelAttribute StastaForm stastaForm) {
        return getStaStaInfo(model, stastaForm.getStation1(), stastaForm.getStation2(), stastaForm.getDate());
    }

    @RequestMapping("/buyStaStaInfo")
    public String buyTicketStaSta(HttpServletRequest request, Model model, @RequestParam("s1") String station1,
                                  @RequestParam("s2") String station2,
                                  @RequestParam("d") Date date,
                                  @RequestParam("id") Integer id) {
        List<BetweenStationsInfo> list = userService.findTicketsBetweenStations(station1, station2, date);
//        list.sort(Comparator.comparing(BetweenStationsInfo::getTicketPrice));
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/user/logInUser";
        }
        Users users = (Users) request.getSession().getAttribute("user");
        int order = userService.purchaseTicketsStaToSta(list.get(id - 1), date, users.getUserId());
        model.addAttribute("error_msg", "购买成功");
        model.addAttribute("orderId", order);
        model.addAttribute("userName", users.getUserName());
        return "lr/purchase";
    }

    //---------------------------------------------------------------------------------------------
    @RequestMapping("/getCityCityInfo")
    public String getCityCityInfo(Model model,
                                  @RequestParam("c1") String city1,
                                  @RequestParam("c2") String city2,
                                  @RequestParam("d") Date date
    ) {
        List<BetweenCitiesInfo> list = userService.findTicketsBetweenCities(city1, city2, date);
        model.addAttribute("infoList", list);
        model.addAttribute("date", date);
        return "lr/citycityInfo";
    }

    @PostMapping("/getCCInfo")
    public String getCityskip(Model model, @ModelAttribute CitycityForm citycityForm) {
        return getCityCityInfo(model, citycityForm.getCity1(), citycityForm.getCity2(), citycityForm.getDate());
    }

    @RequestMapping("/buyCityCityInfo")
    public String buyTicketCityCity(HttpServletRequest request, Model model, @RequestParam("c1") String city1,
                                    @RequestParam("c2") String city2,
                                    @RequestParam("d") Date date,
                                    @RequestParam("id") Integer id) {
        List<BetweenCitiesInfo> list = userService.findTicketsBetweenCities(city1, city2, date);
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/user/logInUser";
        }
        Users users = (Users) request.getSession().getAttribute("user");
        int order = userService.purchaseTicketsCityToCity(list.get(id - 1), date, users.getUserId());
        model.addAttribute("error_msg", "购买成功");
        model.addAttribute("orderId", order);
        model.addAttribute("userName", users.getUserName());
        return "lr/purchase";
    }

    //---------------------------------------------------------------------------------------------
    @RequestMapping("/getTrains")
    public String getTrains(Model model, @RequestParam("trainNumber") String trainNumber) {
        List<Train> list = userService.trainDetailsByTrainNumber(trainNumber);
        model.addAttribute("trainNumber", trainNumber);
        model.addAttribute("infoList", list);
        return "lr/trainInfo";
    }

    @PostMapping("getT")
    public String getTrainSkip(Model model, @ModelAttribute TrainNumberForm trainNumberForm) {
        return getTrains(model, trainNumberForm.getTrainNumber());
    }
//---------------------------------------------------------------------------------------------

    @RequestMapping("/refund")
    public String refund(HttpServletRequest request, Model model, @RequestParam("tid") Integer ticketId) {
        Users users = (Users) request.getSession().getAttribute("user");
        if (users == null) {
            return "redirect:/user/logInUser";
        }
        Integer orderId = userService.refund(ticketId);
        model.addAttribute("orderId", orderId);
        return "lr/refund";
    }
}
