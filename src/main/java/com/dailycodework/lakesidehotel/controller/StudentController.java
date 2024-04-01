package com.dailycodework.lakesidehotel.controller;


import com.dailycodework.lakesidehotel.dto.response.ApiResponse;
import com.dailycodework.lakesidehotel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/student/{id}")
    public ResponseEntity getStudentByRoomId(@PathVariable("id") Long id){
        return ApiResponse.build()
                .withData(service.getStudentsByIdRoom(id))
                .toEntity();
    }
}
