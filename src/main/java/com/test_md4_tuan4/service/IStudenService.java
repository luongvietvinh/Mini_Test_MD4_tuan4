package com.test_md4_tuan4.service;

import com.test_md4_tuan4.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface IStudenService {
    public List<Student> findAll();
    public Page<Student> findAll(Pageable pageable);
    public void save(Student staff);
    public void delete(long id);
    public Student findById(long id);
    public List<Student> findByName (String name);

}
