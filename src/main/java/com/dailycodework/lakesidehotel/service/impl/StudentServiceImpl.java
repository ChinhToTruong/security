package com.dailycodework.lakesidehotel.service.impl;

import com.dailycodework.lakesidehotel.model.Student;
import com.dailycodework.lakesidehotel.repository.RoomRepository;
import com.dailycodework.lakesidehotel.repository.StudentRepository;
import com.dailycodework.lakesidehotel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;
    @Override
    public List<Student> getStudentsByIdRoom(Long id) {
        return studentRepository.getStudentByRoomId(id);
    }

    @Override
    public void deleteStudentFromRoom() {

    }

    @Override
    public void deleteStudentFromDB() {

    }

    @Override
    public Option addStudent() {
        return null;
    }

    @Override
    public Option addRoom() {
        return null;
    }
}
