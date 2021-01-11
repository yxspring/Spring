package com.smart.web;

import com.smart.domain.LoginCommand;
import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {
    private UserService userService;

    //负责处理 /index.html
    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }
    //负责处理/loginCheck.html的请求
    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest req, LoginCommand loginCommand){
        boolean isValidUser=userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if (!isValidUser){
            return new ModelAndView("login","error","用户名或者密码错误！");
        }else{
            User user=userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(req.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            req.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
    @Autowired
    private void setUserService(UserService userService){
        this.userService=userService;
    }
}
