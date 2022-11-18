package com.chori.springStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

  @GetMapping("/board/urltest")
   public String testUrl(@RequestParam String id, @RequestParam String name){
      System.out.println("========>"+ id);
      System.out.println("========>"+ name);
      return "success";
  }

    @PostMapping("/board/urltest1")
    public String testUrl1(){

        return "<h1>success</h1>";
    }

}
