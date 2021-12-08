package com.example.adminproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing      // 감시를 활성화 시키는 Annotation
public class JpaConfig {
}
