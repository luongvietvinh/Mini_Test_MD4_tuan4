package com.test_md4_tuan4.service;

import com.test_md4_tuan4.model.Classroom;
import com.test_md4_tuan4.repository.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomService implements IClassRoomService{
    @Autowired
    ClassroomRepo classroomRepo;
    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classroomRepo.findAll();
    }
}
