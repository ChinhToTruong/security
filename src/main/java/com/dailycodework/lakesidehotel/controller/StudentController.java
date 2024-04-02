package com.dailycodework.lakesidehotel.controller;


import com.dailycodework.lakesidehotel.dto.request.CreateStudentRequest;
import com.dailycodework.lakesidehotel.dto.response.ApiResponse;
import com.dailycodework.lakesidehotel.service.StudentService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/room/{id}")
    public ResponseEntity<?> getStudentByRoomId(@PathVariable("id") Long id) throws Exception {
        return ApiResponse.build()
                .withData(service.getStudentsByIdRoom(id))
                .toEntity();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequest request){
        return ApiResponse.build()
                .withData(service.addStudent(request))
                .toEntity();
    }


    @DeleteMapping("/room/remove/{roomId}/{studentId}")
    public ResponseEntity<?> removeFromRoom(@PathVariable("roomId") Long roomId, @PathVariable("studentId") Long studentId){
        service.deleteStudentFromRoom(roomId, studentId);
        return ApiResponse.build()
                .withMessage("success")
                .toEntity();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromDb(@PathVariable("id") Long id){
        service.deleteStudentFromDB(id);
        return ApiResponse.build()
                .withMessage("success")
                .toEntity();
    }
}
