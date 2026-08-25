package com.example.study.user.entity;

import com.example.study.post.entity.PostEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true, length = 30)
    private String username;

    @Column(nullable=false, length = 30)
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<PostEntity> posts;

    @Builder
    public UserEntity(String username, String password){
        this.username=username;
        this.password=password;
    }
}
