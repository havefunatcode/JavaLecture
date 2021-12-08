package com.example.adminproject.Repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.User;
import com.example.adminproject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class UserRepositoryTest extends AdminProjectApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test02";
        String password = "Test02";
        String status = "REGISTERED";
        String email = "Test02@gmail.com";
        String phoneNumber = "010-1234-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";

        User user = User.builder().
                    account(account).
                    password(password).
                    status(status).
                    email(email).
                    build();
        /*
        Builder Pattern을 사용하면 위와 같이 set Method를 대량으로 생략할 수 있다.
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
         */
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        String phoneNumber = "010-1234-5678";
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);
        /*
        기존 Update를 하기 위해서는 Instance의 set Method를 통해서 Update를 진행했어야 했다.
        user.setEmail();
        user.setStatus();
        그러나 Chain Pattern을 사용하면 다음과 같이 선언할 수 있다.
        user.
            setEmail(email).
            setPhoneNumber(phoneNumber).
            setStatus(status)
         */

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("===============주문 그룹==================");
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("총 금액 : " + orderGroup.getTotalPrice());
            System.out.println("총 수량 : " + orderGroup.getTotalQuantity());

            System.out.println("===============주문 상세==================");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("카테고리 이름 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("주문 브랜드 : " + orderDetail.getItem().getBrandName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착 예정일자 : " + orderDetail.getArrivalDate());
            });

        });
        Assertions.assertNotNull(user);
        // Assertions.assertEquals(user.getPhoneNumber(), phoneNumber);
    }

    @Test
    public void update(){

    }

    @Test
    @Transactional
    public void delete(){

    }

}
