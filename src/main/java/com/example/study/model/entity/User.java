package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //@Table(name = "user") class와 table의 이름이 같다면
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql이기에 전략옵션 IDENTITY
    private Long id;

    //@Column(name = "account") 변수와 table의 entity 이름이 같다면
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
