package com.example.study.post.controller;

import com.example.study.post.dto.PostRequest;
import com.example.study.post.entity.PostEntity;
import com.example.study.post.exception.PostNotFoundException;
import com.example.study.post.repository.PostRepository;
import com.example.study.post.service.PostService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @GetMapping
    public String postForm(){
        return "users/post";
    }


    @PostMapping
    public String createPost(@Valid @ModelAttribute PostRequest request,
                             HttpSession session){

        postService.createPost(request,session);

        return "redirect:/users/main";
    }

    @GetMapping("/{postId}")
    public String detailGetPost(@PathVariable Long postId, Model model){
        PostEntity post = postService.getPostDetailed(postId);
        model.addAttribute("post",post);
        return "users/detail";
    }

    @GetMapping("/{postId}/edit")
    public String postEditForm(@PathVariable Long postId,
                               HttpSession session,
                               Model model){
        PostEntity post= postService.getPostPatchForm(postId,session);

        model.addAttribute("post",post);
        return "users/postEditForm";
    }

    @PatchMapping("/{postId}")
    public String editPost(@PathVariable Long postId,
                           @ModelAttribute PostRequest request,
                           HttpSession session){

        postService.postPatch(postId,request,session);
        return "redirect:/users/post/{postId}";
    }
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId,
                             HttpSession session){
        postService.deletePost(postId,session);
        return "redirect:/users/main";
    }
}
