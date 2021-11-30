package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    //HTML <Form>
    //ajax 검색
    //http post body에 넣어서 data를 보내겠다.
    //json, xml, multipart-form / text-plain

    @PostMapping(value = "/postMethod")//produces = {"application-json"}) //지원할 수 있는 형태를 넣을 수 있따.
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        System.out.println("SearchParam");

        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }

    @DeleteMapping("/delteMethod")
    public void delete(){

    }

}
