package com.example.wospringmvc.controller;


import com.example.wospringmvc.repository.UsersRepository;
import com.example.wospringmvc.service.JoinService;
import com.example.wospringmvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UsersController {

    @Autowired
    private JoinService joinService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/joinRequest")
    public String joinRequest(@RequestParam Map<String,String> paramMap){

        String userId = paramMap.get("user_id");
        String userPw = paramMap.get("user_pw");
        String userName = paramMap.get("user_name");

        String page = joinService.joinUser(userId, userPw, userName);


        return page;
    }

    @PostMapping("/loginRequest")
    public String loginRequest(@RequestParam Map<String,String> parseMap){
        String userId = parseMap.get("user_id");
        String userPw = parseMap.get("user_pw");


       String page =  loginService.login(userId,userPw);

        return page;

    }
}
