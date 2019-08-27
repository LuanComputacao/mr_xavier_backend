package com.luancomputacao.mr_xavier_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/index/")
    public ResponseEntity index(){
        return ResponseEntity.ok("index");
    }
}
