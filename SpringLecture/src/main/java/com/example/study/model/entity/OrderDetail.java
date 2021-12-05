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
@Entity     // order_detail
@ToString(exclude = {"user", "item"})       // 상호참조하고 있는 toString 제외시켜주기
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime order_at;
    // N : 1 (OrderDetail의 입장)
    @ManyToOne
    private User user;  // user_id를 hibernate에서 자동으로 매핑시켜준다.
    // N : 1 (OrderDetail의 입장)
    @ManyToOne
    private Item item;
}
