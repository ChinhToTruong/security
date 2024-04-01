package com.dailycodework.lakesidehotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date startedAt;
    private Date finishedAt;
    private String description;

//    @OneToOne
//    @JoinColumn(name = "teacher_id")
//    private Teacher teacher;
    @ManyToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students;
}
