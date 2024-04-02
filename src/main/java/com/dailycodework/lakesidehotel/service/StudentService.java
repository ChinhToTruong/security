package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.dto.request.CreateStudentRequest;
import com.dailycodework.lakesidehotel.model.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getStudentsByIdRoom(Long id) throws Exception;
    void deleteStudentFromRoom(Long roomId, Long studentId);

    void deleteStudentFromDB(Long id);
    Optional<?> addStudent(CreateStudentRequest request);

}
