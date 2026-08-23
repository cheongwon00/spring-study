package com.example.study.auth.service;

import com.example.study.auth.dto.AuthLoginRequest;
import com.example.study.auth.exception.InvalidPasswordException;
import com.example.study.auth.exception.UserNotFoundException;
import com.example.study.user.entity.UserEntity;
import com.example.study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public Long login(AuthLoginRequest request){

        UserEntity userEntity =  userRepository.findByName(request.name()).orElseThrow(()->new UserNotFoundException("로그인 실패"));

        if(!userEntity.getPassword().equals(request.password())){
            throw new InvalidPasswordException("잘못된 비밀번호입니다.");
        }

        return userEntity.getId();
    }
}
