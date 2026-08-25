package com.example.study.post.entity;

import com.example.study.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post")
@Getter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100, nullable = false)
    String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserEntity user;

    @Builder
    public PostEntity(String title,String content,UserEntity user){
        this.title=title;
        this.content= content;
        this.user = user;
    }
}
