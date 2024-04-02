package com.dailycodework.lakesidehotel.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CreateRoomRequest {
    private String name;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startAt;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endAt;
}
