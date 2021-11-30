package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    //1 : N    = 자기자신은 1이지만 상대방은 N이기에 List로 해줘야한다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") //orderdetail 클래스에서 user과 mapping
    private List<OrderDetail> orderDetailList;
}
