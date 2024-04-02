package com.dailycodework.lakesidehotel.service.impl;

import com.dailycodework.lakesidehotel.dto.request.CreateRoomRequest;
import com.dailycodework.lakesidehotel.exception.customs.UserAlreadyExistsException;
import com.dailycodework.lakesidehotel.model.Room;
import com.dailycodework.lakesidehotel.repository.RoomRepository;
import com.dailycodework.lakesidehotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    final RoomRepository roomRepository;
    @Override
    public Optional<?> createRoom(CreateRoomRequest request) {
        if (roomRepository.findRoomByName(request.getName()).isPresent()){
            throw new UserAlreadyExistsException("room exist");
        }
        return Optional.of(roomRepository.save(Room.builder()
                .name(request.getName())
                .description(request.getDescription())
                .finishedAt(request.getEndAt())
                .startedAt(request.getStartAt())
                .build()));
    }

    @Override
    public List<?> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public void deleteRoom(Long id) {
        var room = roomRepository.findById(id).orElseThrow();
        roomRepository.delete(room);
    }
}
