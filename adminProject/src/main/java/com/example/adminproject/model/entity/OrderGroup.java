package com.example.adminproject.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "orderDetailList"})
@EntityListeners(AuditingEntityListener.class)
@Builder        // Builder Pattern(Constructor 패턴 중 하나)
@Accessors(chain = true)        // Chaining된 형태로 객체를 관리할 수 있다.
public class OrderGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String orderType;       // 일괄 주문 | 개별 주문
    private String revAddress;
    private String revName;
    private String paymentType;     // Card | Cash
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    // 반복되는 부분 자동으로 들어가게 설정
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;
    // Foriegn Key

    // OrderGroup : User = N : 1
    @ManyToOne
    private User user;

    // OrderGroup : OrderDetail = 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;
}
