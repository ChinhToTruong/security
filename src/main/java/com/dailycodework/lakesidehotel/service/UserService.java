package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.model.User;
import com.dailycodework.lakesidehotel.dto.request.LoginRequest;
import com.dailycodework.lakesidehotel.dto.request.RegisterRequest;
import com.dailycodework.lakesidehotel.dto.response.JwtResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    User registerUser(RegisterRequest request);
    ResponseEntity<JwtResponse>  auth(LoginRequest request);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
}
