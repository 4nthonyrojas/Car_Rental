package com.cibertec.carsystemusuario.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${mensaje}")
    private String mensaje;

    @GetMapping("/mensaje")
    public String getMensaje() {
        return this.mensaje;
    }
}
