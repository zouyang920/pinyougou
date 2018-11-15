package com.itheima.web;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login(User user, Model model, HttpServletRequest request) {

        User dbUser = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(dbUser!=null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/account/findAll";
        }

        model.addAttribute("loginMsg", "用户名或秘密错误");
        return "/login.jsp";
    }
}
