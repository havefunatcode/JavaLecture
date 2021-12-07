package com.example.adminproject.Repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.OrderDetail;
import com.example.adminproject.repository.OrderDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminProjectApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
    }

    @Test
    public void read(){

    }
}
