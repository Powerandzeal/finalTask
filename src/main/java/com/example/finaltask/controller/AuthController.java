package com.example.finaltask.controller;

import com.example.finaltask.service.UserDTOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.finaltask.model.dto.LoginReq;
import com.example.finaltask.model.dto.RegisterReq;
import com.example.finaltask.configuration.Role;
import com.example.finaltask.service.AuthService;

import static com.example.finaltask.configuration.Role.USER;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
public class AuthController {
    public AuthController(AuthService authService, UserDTOService userDTOService) {
        this.authService = authService;
        this.userDTOService = userDTOService;
    }

    private final AuthService authService;

    private UserDTOService userDTOService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq req) {
        if (authService.login(req.getUsername(), req.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterReq req) {
        Role role = req.getRole() == null ? USER : req.getRole();
        if (authService.register(req, role)) {
            userDTOService.addUser1(req);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
