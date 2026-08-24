package com.example.study.user.service;

import com.example.study.user.dto.SignupRequest;
import com.example.study.user.entity.UserEntity;
import com.example.study.user.exception.DuplicateUsernameException;
import com.example.study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signup(SignupRequest request){

        if(userRepository.existsByUsername(request.username())){
            throw new DuplicateUsernameException("username 중복!");
        }
        UserEntity userEntity = UserEntity.builder()
                .username(request.username())
                .password(request.password())
                .build();
        userRepository.save(userEntity);
    }

    public UserEntity getUser(Long id){
        return userRepository.findById(id).get();
    }

    public void userDelete(Long id){
        userRepository.deleteById(id);
    }
}
