package com.example.study.post.repository;

import com.example.study.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,Long> {

    List<PostEntity> findAllByOrderByIdDesc();
}
