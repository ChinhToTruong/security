package com.dailycodework.lakesidehotel.repository;

import com.dailycodework.lakesidehotel.model.Student;
import org.hibernate.sql.exec.spi.JdbcCallParameterExtractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select * from student s join (select * from student_room sr where sr.room_id = ?1) as tp on tp.student_id = s.id ", nativeQuery = true)
    List<Student> getStudentByRoomId(Long roomId);

    Optional<?> findByName(String name);
}
