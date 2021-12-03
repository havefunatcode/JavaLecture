package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    // @RequestMapping(method = RequestMethod.POST, path = "postMethod")
    // 아래의 @PostMapping("/postMethod")와 같은 역할을 한다.
    @PostMapping(value ="/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        
        return searchParam;
    }

}
