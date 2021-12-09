package com.example.adminproject.Repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.OrderDetail;
import com.example.adminproject.repository.OrderDetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminProjectApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");
        //orderDetail.setItemId(1L);
        //orderDetail.setOrderGroupId(1L);        // 장바구니 역할

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }

    @Test
    public void read(){

    }
}
