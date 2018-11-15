package com.itheima.web;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("findAll")
    public ModelAndView findAll() {

        ModelAndView modelAndView = new ModelAndView();

        List<Account> accounts = accountService.findAll();
        modelAndView.addObject("accounts", accounts);
        modelAndView.setViewName("/WEB-INF/pages/list.jsp");

        return modelAndView;
    }

    @RequestMapping("addAccount")
    public String addAccount(HttpServletRequest request, HttpServletResponse response, Account account, MultipartFile imgFile) throws IOException {

        //获取上传图片的名字
        String originalFilename = imgFile.getOriginalFilename();

        ServletContext servletContext = request.getSession().getServletContext();
        File file = new File(servletContext.getRealPath("images"), originalFilename);

        //图片保存到file
        imgFile.transferTo(file);
        System.out.println("保存图片到:"+file);

        //设置图片保存的路径
        String imgPath = servletContext.getContextPath() + "/images/" +  originalFilename;
        //保存图片路径
        account.setImgSrc(imgPath);

        accountService.add(account);
        //添加完数据重定向到查询页面
        return "redirect:findAll";
        //response.sendRedirect(request.getContextPath()+"/account/findAll");

    }


}
