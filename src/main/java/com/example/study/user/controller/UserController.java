package com.example.study.user.controller;

import com.example.study.user.dto.SignupRequest;
import com.example.study.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String signup(){
        return "users/signup";
    }

    @PostMapping
    public String signupFrom(@Valid @ModelAttribute SignupRequest request){
        userService.signup(request);
        log.info("signup success!!!!");
        return "redirect:/";
    }
}
