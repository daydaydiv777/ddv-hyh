package com.ddv.hyh.controllers;

import com.ddv.hyh.common.ServiceResponse;
import com.ddv.hyh.pojo.User;
import com.ddv.hyh.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping(value = "signIn")
    public ServiceResponse<User> SignIn(String username, String password, HttpSession httpSession) {
        ServiceResponse<User> response = iUserService.signIn(username, password);
        if(response.isSuccess()) {
            System.out.println(1);
        }
        return response;
    }
}
