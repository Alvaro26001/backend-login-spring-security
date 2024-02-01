package com.login.otroLogin.controller;

import com.login.otroLogin.dto.reques.AuthenticationRequest;
import com.login.otroLogin.dto.response.AuthenticationResponse;
import com.login.otroLogin.service.impl.AuthenticationImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationImpl authentication;

    @PostMapping("/authorize")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request){

        AuthenticationResponse jwtDto = this.authentication.login(request);

        return ResponseEntity.ok(jwtDto);
    }

    @GetMapping("/getTests")
    public String prueba(){

        return "Tests integration";
    }
}
