package com.example.study.common;

import com.example.study.auth.exception.InvalidPasswordException;
import com.example.study.auth.exception.UserNotFoundException;
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

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(
            UserNotFoundException e,
            Model model
    ){
        model.addAttribute("errorMessage : ",e.getMessage());

        return "users/login";
    }
    @ExceptionHandler(InvalidPasswordException.class)
    public String handleInvalidPasswordException(
            InvalidPasswordException e,
            Model model
    ){
        model.addAttribute("errorMessage : ",e.getMessage());

        return "users/login";
    }

}
