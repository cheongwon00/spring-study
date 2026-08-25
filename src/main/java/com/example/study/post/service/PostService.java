package com.example.study.post.service;

import com.example.study.post.dto.PostRequest;
import com.example.study.post.entity.PostEntity;
import com.example.study.post.exception.PostNotFoundException;
import com.example.study.post.repository.PostRepository;
import com.example.study.user.entity.UserEntity;
import com.example.study.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void createPost(PostRequest request, HttpSession session){

        Long userId = (Long) session.getAttribute("userId");
        UserEntity user = userRepository.findById(userId).get();

        PostEntity entity = PostEntity.builder()
                .title(request.title())
                .content(request.content())
                .user(user)
                .build();

        postRepository.save(entity);
    }


    public List<PostEntity> getPost(){
        return postRepository.findAllByOrderByIdDesc();
    }

    public PostEntity getPostDetailed(Long id){
        PostEntity post = postRepository.findById(id)
                .orElseThrow(()->new PostNotFoundException("게시물을 찾을 수 없습니다."));

        return post;
    }
}
