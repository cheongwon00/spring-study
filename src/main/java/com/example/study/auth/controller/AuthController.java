package com.example.study.auth.controller;

import com.example.study.auth.dto.AuthLoginRequest;
import com.example.study.auth.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String login(){
        return "users/login";
    }

    @PostMapping("/login")
    public String loginForm(@Valid @ModelAttribute AuthLoginRequest request,
                            HttpSession session){

        Long id = authService.login(request);
        log.info("{} login 성공!",id);

        session.setAttribute("userId",id);
        return "redirect:/users/main";
    }


    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
