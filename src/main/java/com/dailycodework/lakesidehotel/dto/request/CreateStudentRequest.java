package com.dailycodework.lakesidehotel.dto.request;

import com.dailycodework.lakesidehotel.model.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateStudentRequest {
    private String name;
    private String email;
    private String gender;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private String number;
    List<Long> rooms;
}
