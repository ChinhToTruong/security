package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.dto.request.CreateRoomRequest;
import com.dailycodework.lakesidehotel.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Optional<?> createRoom(CreateRoomRequest request);

    List<?> getAllRoom();

    void deleteRoom(Long id);
}
