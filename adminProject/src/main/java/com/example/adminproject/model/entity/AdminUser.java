package com.example.adminproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)  // parameter Class를 사용하여 감시하겠다.
@Builder        // Builder Pattern(Constructor 패턴 중 하나)
@Accessors(chain = true)        // Chaining된 형태로 객체를 관리할 수 있다.
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private Integer loginFailCount;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    // 반복되는 부분 자동으로 들어가게 설정
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    /*
        Annotation에 By라는 단어가 들어가면 별도로 지정하지 않더라도 Config파일에서 Return하는 값을 반영받는다.
        Create의 경우 Entity가 최초로 생성될 때 값이 할당되며,
        LastModified의 경우 Entity가 마지막으로 수정될 때 값이 할당된다.
     */
}
