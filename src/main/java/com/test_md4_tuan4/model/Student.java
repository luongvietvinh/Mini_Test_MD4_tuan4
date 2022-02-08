package com.test_md4_tuan4.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;
    private String address;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private Classroom classroom;

}
