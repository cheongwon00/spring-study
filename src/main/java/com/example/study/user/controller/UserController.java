package com.example.study.user.controller;

import com.example.study.post.entity.PostEntity;
import com.example.study.post.service.PostService;
import com.example.study.user.dto.SignupRequest;
import com.example.study.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @GetMapping
    public String signup(){
        return "users/signup";
    }

    @PostMapping
    public String signupForm(@Valid @ModelAttribute SignupRequest request){
        userService.signup(request);
        log.info("signup success!!!!");
        return "redirect:/";
    }

    @GetMapping("/main")
    public String main(Model model){
        List<PostEntity> posts = postService.getPost();
        model.addAttribute("posts",posts);
        return "users/main";
    }

    @DeleteMapping("/delete")
    public String userDelete(HttpSession session){
        Long userId = (Long)session.getAttribute("userId");
        userService.userDelete(userId);
        session.invalidate();
        return "redirect:/";
    }
}
