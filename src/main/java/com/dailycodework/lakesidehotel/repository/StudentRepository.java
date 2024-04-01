package com.dailycodework.lakesidehotel.repository;

import com.dailycodework.lakesidehotel.model.Student;
import org.hibernate.sql.exec.spi.JdbcCallParameterExtractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s from Student s where s.id = ?1")
    List<Student> getStudentByRoomId(Long roomId);
}
