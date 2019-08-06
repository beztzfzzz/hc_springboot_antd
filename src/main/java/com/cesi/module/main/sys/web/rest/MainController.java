package com.cesi.module.main.sys.web.rest;

import com.cesi.module.base.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value="/")
public class MainController extends BaseController{

	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public void doLogin(String username,String password,HttpServletResponse response) throws IOException{
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        response.sendRedirect("home");
    }
}
