package cn.mimik.finance.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
//如果返回的为json数据或其它对象，添加该注解  
@ResponseBody
public class GlobalExceptionHandler {  
    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例  
    @ExceptionHandler(Exception.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request, Exception exception) throws Exception{
        return "404";
    }
}  