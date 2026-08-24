package com.example.study.user.controller;

import com.example.study.user.dto.MyPageResponse;
import com.example.study.user.entity.UserEntity;
import com.example.study.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final UserService userService;

    @GetMapping
    public String myPage(HttpSession session,
                         Model model){
        Long userId = (Long) session.getAttribute("userId");

        UserEntity ue = userService.getUser(userId);
        MyPageResponse user = new MyPageResponse(ue.getUsername());
        model.addAttribute("user",user);

        return "/users/mypage";
    }
}
