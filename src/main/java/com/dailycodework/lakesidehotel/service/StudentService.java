package com.dailycodework.lakesidehotel.service;

import com.dailycodework.lakesidehotel.model.Student;

import javax.swing.text.html.Option;
import java.util.List;

public interface StudentService {
    List<Student> getStudentsByIdRoom(Long id);
    void deleteStudentFromRoom();

    void deleteStudentFromDB();
    Option addStudent();

    Option addRoom();
}
