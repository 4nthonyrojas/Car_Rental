package com.cibertec.carsystemauto.controller;

import com.cibertec.carsystemauto.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auto/v1")
public class AutoController {

    @Autowired
    private IAutoService autoService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(this.autoService.getAllAutos());
    }
}
