package com.dailycodework.lakesidehotel.controller;

import com.dailycodework.lakesidehotel.exception.customs.UserAlreadyExistsException;
import com.dailycodework.lakesidehotel.dto.request.LoginRequest;
import com.dailycodework.lakesidehotel.dto.request.RegisterRequest;
import com.dailycodework.lakesidehotel.security.jwt.JwtUtils;
import com.dailycodework.lakesidehotel.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterRequest request){
        try{
            return ResponseEntity.ok(userService.registerUser(request));

        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.auth(request));
    }
}
