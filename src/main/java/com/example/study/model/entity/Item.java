package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql이기에 전략옵션 IDENTITY
    private Long id;

    private String name;

    private Integer price;

    private String content;

    //1 : N
    // Lazy = 지연로딩(select * from item where id =?), EAGER=즉시로딩(select *~~~ 모든 조인) 성능이 느려질 수 있음. onetoOne에서 추천
    //item_iid = order.detail.item_id
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
