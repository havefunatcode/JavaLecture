package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.util.AssertionErrors;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    @Autowired      // DI(Dependency Injection) : 사용자가 관리하지 않고 Spring이 관리해준다. 기본적으로 Singleton이다.
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("TestUser01");
        // user.setId(); // auto Increment이기 때문에 설정할 필요 없음.
        user.setEmail("TestUser01@daum.net");
        user.setPhoneNumber("010-1234-5678");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("new User : " + newUser);
    }

    @Test
    @Transactional
    public void read() {
        // User user = userRepository.findById(2L); // return type Optional기 때문에 에러가 발생한다.
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail -> {
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }

    @Test
    public void update() {
        // select를 먼저 진행해야 한다.
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            // selectUser.setId(3L);        // Id를 3으로 설정해주면 2번 id가 아닌 3번 id를 갖고 있는 column값이 update된다.
            selectUser.setAccount("PPPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("admin");

            userRepository.save(selectUser);
            // jpa에서 해당 id가 존재하는지 판단하고 존재하면 update를 진행해준다.
        });
    }

    @Test
    @Transactional // Test를 진행하면 마지막에 Rolled back transaction이 진행된다.
    //@DeleteMapping("/api/user")
    public void delete() {
        // select를 먼저 진행해야 한다.
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());
        // True인 경우 test 정상
        // False인 경우 test 에러

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);      // return이 없는 void이다.
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent());
        /*
        if(deleteUser.isPresent()){
            System.out.println("User : " + deleteUser.get());
        } else {
            System.out.println("존재하지 않습니다.");
        }
         */
    }
}
