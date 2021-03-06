package com.example.adminproject.Repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.Partner;
import com.example.adminproject.repository.PartnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class PartnerRepositoryTest extends AdminProjectApplicationTests {
    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        //partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);

        Assertions.assertNotNull(newPartner);
        Assertions.assertEquals(newPartner.getName(), name);
    }

    @Test
    public void read() {
        Optional<Partner> partner = partnerRepository.findById(1L);

        partner.ifPresent(p -> {
            System.out.println(p.getName());
            System.out.println(p.getCeoName());
            System.out.println(p.getPartnerNumber());
        });
    }
}
