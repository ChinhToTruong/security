package com.dailycodework.lakesidehotel.service.impl;

import com.dailycodework.lakesidehotel.dto.request.CreateStudentRequest;
import com.dailycodework.lakesidehotel.exception.customs.UserAlreadyExistsException;
import com.dailycodework.lakesidehotel.model.Room;
import com.dailycodework.lakesidehotel.model.Student;
import com.dailycodework.lakesidehotel.repository.RoomRepository;
import com.dailycodework.lakesidehotel.repository.StudentRepository;
import com.dailycodework.lakesidehotel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;
    @Override
    public List<Student> getStudentsByIdRoom(Long id) throws Exception {
        if (roomRepository.findById(id).isEmpty()){
            throw new Exception("Room not existed");
        }
        return studentRepository.getStudentByRoomId(id);
    }

    @Override
    public void deleteStudentFromRoom(Long roomId, Long studentId) {
        var student = studentRepository.findById(studentId).orElseThrow();
        if (!student.getRooms().contains(roomRepository.findById(roomId).orElseThrow())){
            throw new UsernameNotFoundException("user khong trong room nay");
        }
        var room = roomRepository.findById(roomId).orElseThrow();
        student.getRooms().remove(room);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentFromDB(Long id) {
        var student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
    }

    @Override
    public Optional<?> addStudent(CreateStudentRequest request) {
        if (studentRepository.findByName(request.getName()).isPresent()){
            throw new UserAlreadyExistsException("Student existed");
        }

        List<Room> rooms = new ArrayList<>();
        request.getRooms().forEach(r -> {
            var room  = roomRepository.findById(r).orElseThrow();
            rooms.add(room);
        });
        return Optional.of(studentRepository.save(Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                        .rooms(rooms)
                .build()));
    }

}
