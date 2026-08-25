package com.example.study.common;

import com.example.study.auth.exception.LoginFailedException;
import com.example.study.post.exception.PostNotFoundException;
import com.example.study.user.exception.DuplicateUsernameException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUsernameException.class)
    public String handleDuplicateUsernameException(
            DuplicateUsernameException e,
            Model model
    ){
        model.addAttribute("errorMessage",e.getMessage());

        return "users/signup";
    }

    @ExceptionHandler(LoginFailedException.class)
    public String handleLoginFailedException(
            LoginFailedException e,
            Model model
    ){
        model.addAttribute("errorMessage","아이디 또는 비밀번호가 올바르지 않습니다.");
        return "users/login";
    }

    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostNotFoundException(
            PostNotFoundException e,
            Model model){
        model.addAttribute("errorMessage","게시글을 찾을 수 없습니다");
        return "users/main";
    }
}
