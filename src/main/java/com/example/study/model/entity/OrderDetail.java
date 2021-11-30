package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //entity라고 되어있으면 java는 카멜케이스를 쓰지만 database를 연결할때는 스네이크 케이스를 쓰기에 자동으로 연결된다.
@ToString(exclude = {"user","item"}) //연관참조하고 있기 때문에 toString을 계속 서로 불러오면서 오버플로우가 생긴다.
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql이기에 전략옵션 IDENTITY
    private Long id;

    private LocalDateTime orderAt;

    //N : 1  -  나 자신을 기준으로 생각하면 ManyToOne
    @ManyToOne
    private User user; //userid; 를 찾아간다. hibernate가
    //private Long userId;  그래서 이것도 바꿔줘야 한다. hibernate를 통한 연관관계 설정이기에

    //N : 1
    @ManyToOne
    private Item item;
//    private Long itemId;
}
