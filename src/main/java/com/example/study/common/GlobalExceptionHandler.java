package com.example.study.common;

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
        model.addAttribute("errorMessage : ",e.getMessage());

        return "users/signup";
    }

}
