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
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1234-5678";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    public void read(){
        String phoneNumber = "010-1234-5678";
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getPhoneNumber(), phoneNumber);
    }

    @Test
    public void update(){

    }

    @Test
    @Transactional
    public void delete(){

    }

}
