package com.example.adminproject.Repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.Item;
import com.example.adminproject.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends AdminProjectApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {
        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북입니다.");
        item.setPrice(900000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        // item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);

        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read() {
        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);
        Assertions.assertTrue(item.isPresent());
    }
}
