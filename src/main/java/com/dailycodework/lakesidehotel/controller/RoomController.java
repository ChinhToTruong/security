package com.dailycodework.lakesidehotel.controller;


import com.dailycodework.lakesidehotel.dto.request.CreateRoomRequest;
import com.dailycodework.lakesidehotel.dto.response.ApiResponse;
import com.dailycodework.lakesidehotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestBody CreateRoomRequest request){
        return ApiResponse.build()
                .withData(roomService.createRoom(request))
                .toEntity();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable(name = "id") Long id){
        roomService.deleteRoom(id);
        return ApiResponse.build()
                .withMessage("success")
                .toEntity();
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ApiResponse.build()
                .withData(roomService.getAllRoom())
                .toEntity();
    }
}
