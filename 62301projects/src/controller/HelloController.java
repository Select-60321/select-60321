package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception{
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("welcome", "Welcome to 60321 railway system!");
        return mav;
    }
}
