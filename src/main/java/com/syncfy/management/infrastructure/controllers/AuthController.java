package com.syncfy.management.infrastructure.controllers;

import com.syncfy.management.domain.AuthDtoCreatorDomain;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;
import com.syncfy.management.infrastructure.services.IAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private IAuthService authService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String home() {
        log.info("hi from the auth controller");
        return "  Hello";
    }

    @PostMapping("/check-auth")
    public ResponseEntity<AuthDtoDomain> validateOAuth(@RequestBody AuthDtoPayloadDomain payloadDomain) {
        AuthDtoDomain authDtoDomain = authService.validateOAuth(payloadDomain);
        return new ResponseEntity<>(authDtoDomain, HttpStatus.OK);
    }

    @PostMapping("/log-auth")
    public ResponseEntity<AuthDtoDomain> newOAuthRegister(@RequestBody AuthDtoCreatorDomain domain){
        AuthDtoDomain authDtoDomain = authService.newOAuthRegister(domain);
        return new ResponseEntity<>(authDtoDomain, HttpStatus.OK);
    }
}
