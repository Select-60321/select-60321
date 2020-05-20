package com.example.demo59.controller;

import com.example.demo59.entity.*;
import com.example.demo59.service.AdminService;
import com.example.demo59.utils.MD5Util;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //登录成功之后的欢迎界面
    @RequestMapping("/welcomeAdmin")
    public String welcome(HttpServletRequest request) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:/admin/logInAdmin";
        }
        return "/lr/welcomeAdmin";
    }

    @RequestMapping("/outAdmin")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("admin");
        response.sendRedirect("/admin/logInAdmin");
    }

    @GetMapping("/logInAdmin")
    public String listAdmin() {
        return "lr/loginAdmin";
    }


    @PostMapping("/logInAdmin")
    public String Adminlogin(@Valid LogInform logInform, BindingResult
            result, RedirectAttributes attributes,
                             HttpServletRequest request) {

        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                if (Objects.equals(error.getDefaultMessage(), "Username shouldn't be null")) {
                    attributes.addFlashAttribute("errorMsg_0",
                            errors.get(0).getDefaultMessage());
                } else {
                    attributes.addFlashAttribute("errorMsg_1",
                            errors.get(0).getDefaultMessage());
                }
            }
            return "redirect:/admin/logInAdmin";
        } else {
            Admin admin = new Admin();
            admin.setAdminName(logInform.getUserName());
            admin.setPassword(MD5Util.generatePassword(logInform.getPassword()));
            Admin admin1 = adminService.findExistAdmin(admin);
            if (admin1 != null) {
                request.getSession().setAttribute("admin", admin1);
                return "redirect:/admin/welcomeAdmin";
            }
            attributes.addFlashAttribute("errorMsg",
                    "the username or password is wrong");
            return "redirect:/admin/logInAdmin";
        }
    }

    //451 深圳北 23 北京西 12 上海虹桥 16 广州南 2647 香港西九龙 1503 武汉
    @RequestMapping("/addAStation")
    public String addStation(Model model, HttpServletRequest request,
                             @RequestParam("tr") String trainNum,
                             @RequestParam("sid") Integer stationId,
                             @RequestParam("at") Time arriveTime,
                             @RequestParam("ut") Time updateDepartTime,
                             @RequestParam("ad") Integer arriveDay,
                             @RequestParam("ud") Integer updateDepartDay,
                             @RequestParam("d") Integer distance
    ) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:/admin/logInAdmin";
        }
        adminService.insertOneStationIntoExistTrain(trainNum, stationId,
                arriveTime, arriveDay, distance, updateDepartTime, updateDepartDay);
        model.addAttribute("msg", "加站成功");
        return "lr/aftermodification";
    }

    @RequestMapping("addsta")
    public String addStaSkip(Model model, HttpServletRequest request, AddStationForm addStationForm) {
        return addStation(model, request,
                addStationForm.getTrainNumber(),
                addStationForm.getStationId(),
                addStationForm.getArriveTime(),
                addStationForm.getUpdateDepartTime(),
                addStationForm.getArriveDay(),
                addStationForm.getUpdateDepartDay(),
                addStationForm.getDistance());
    }

    /**
     * 取消/恢复火车站，像covid-19封城一样
     *
     * @param request
     * @param stationName
     * @param status
     * @return
     */
    @RequestMapping("/chgstatus")
    public String changeStatus(Model model, HttpServletRequest request, @RequestParam("sname") String stationName,
                               @RequestParam("status") Integer status) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:/admin/logInAdmin";
        }
        adminService.updateActiveInfoSingle(stationName, status);
        model.addAttribute("msg", "修改车站信息成功");
        return "lr/aftermodification";
    }

    /**
     * 与上面方法配套
     *
     * @param model
     * @param request
     * @param changeStationForm
     * @return
     */
    @RequestMapping("/cgst")
    public String changeStatusSkip(Model model, HttpServletRequest request, ChangeStationForm changeStationForm) {
        int status = 0;
        if (changeStationForm.getStatus().equals("取消")) {
            status = 1;
        }
        return changeStatus(model, request, changeStationForm.getTrainNumber(), status);
    }

    @RequestMapping("/cgstonetrain")
    public String changeStationInOneTrain(Model model,
                                          HttpServletRequest request,
                                          @RequestParam("trainno") String trainNumber,
                                          @RequestParam("staidx") Integer stationIdx,
                                          @RequestParam("status") Integer status) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:/admin/logInAdmin";
        }
        adminService.validateStation(trainNumber, stationIdx, status);
        model.addAttribute("msg", "修改车次成功");
        return "lr/aftermodification";
    }

    @RequestMapping("/cgstot")
    public String changeStationInOneTrainSkip(Model model,
                                              HttpServletRequest request,
                                              ChangeStationInTrainForm changeStationInTrainForm) {
        int status = 0;
        if (changeStationInTrainForm.getStatus().equals("取消")) {
            status = 1;
        }
        return changeStationInOneTrain(model, request, changeStationInTrainForm.getTrainNumber(),
                changeStationInTrainForm.getStationIndex(),
                status);
    }

    @RequestMapping("/cancel")
    public String cancelTrain(Model model,
                              HttpServletRequest request,
                              @RequestParam("trainno") String trainNumber,
                              @RequestParam("status") Integer status) {
        if (request.getSession().getAttribute("admin") == null) {
            return "redirect:/admin/logInAdmin";
        }
        adminService.cancelOneTrain(trainNumber, status);
        model.addAttribute("msg", "修改车次成功");
        return "lr/aftermodification";
    }

    @RequestMapping("/cc")
    public String cancelTrainSkip(Model model, HttpServletRequest request, CancelTrain cancelTrain) {
        int status = 0;
        if (cancelTrain.getStatus().equals("取消")) {
            status=2;
        }
        model.addAttribute("msg", "修改成功");
        return cancelTrain(model, request, cancelTrain.getTrainNumber(), status);
    }
}
