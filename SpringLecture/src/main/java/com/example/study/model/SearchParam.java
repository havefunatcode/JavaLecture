package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor     // 모든 인자에 대한 생성자
public class SearchParam {
    private String account;
    private String email;
    private int page;
}
