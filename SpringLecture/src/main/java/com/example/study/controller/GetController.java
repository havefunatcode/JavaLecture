package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")     // Localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path="/getMethod")  // Localhost:8080/api/getMethod
    public String getRequest() {
        return "Hi GetMethod!";
    }

    @GetMapping("/getParameter")    // Localhost:8080/api/getParameter
    public String getParameter(@RequestParam String id, @RequestParam String password) {
        System.out.println(id);
        System.out.println(password);
        return "id : " + id + "</br>" + "password : " + password;
    }

    // Localhost:8080/api/multiParameter
    @GetMapping("getMultiParams")
    public SearchParam getMultiParams(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        
        // JSON타입으로 객체를 return하길 원함
        // Jackson Library 사용하여 자동 형변환
        // return type을 객체로 변경하면 됨
        // {"account" : "", "email" : "", "page" : 0}
        return searchParam;
    }
}
