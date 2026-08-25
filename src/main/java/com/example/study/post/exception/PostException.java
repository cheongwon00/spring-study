package com.example.study.post.exception;

import lombok.Getter;

@Getter
public class PostException extends RuntimeException {

    private final Long postId;
    public PostException(String message,Long postId) {
        super(message);
        this.postId=postId;
    }
}
