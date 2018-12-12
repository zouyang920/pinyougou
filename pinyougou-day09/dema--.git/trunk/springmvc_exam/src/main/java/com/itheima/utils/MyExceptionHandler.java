package com.itheima.utils;


import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

public class MyExceptionHandler implements HandlerExceptionResolver {

    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/pages/error.jsp");
        if(e instanceof MaxUploadSizeExceededException) {
            modelAndView.addObject("errorMsg", "您上传的文件过大，最大允许2M,请重新上传");
        } else {
            modelAndView.addObject("errorMsg", "服务器繁忙");
        }
        if (e!=null) {
            e.printStackTrace();
        }

        return modelAndView;
    }
}
