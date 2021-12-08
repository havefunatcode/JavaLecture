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
@Entity
//@Table(name="user") // class의 이름과  table이 이름이 같으면 굳이 선언하지 않아도 JPA에서 매칭시켜준다.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name="account")
    // 변수의 이름과 Column명이 같으면 선언하지 않아도 된다.
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1 : N (User의 입장)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")   // 어떠한 변수에 매핑시킬건지 명시
    private List<OrderDetail> orderDetailList;
}
