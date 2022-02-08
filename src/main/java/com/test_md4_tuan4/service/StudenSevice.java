package com.test_md4_tuan4.service;

import com.test_md4_tuan4.model.Student;
import com.test_md4_tuan4.repository.StudenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudenSevice implements IStudenService{
    @Autowired
    StudenRepo studenRepo;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studenRepo.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studenRepo.findAll(pageable);
    }

    @Override
    public void save(Student student) {
studenRepo.save(student);
    }

    @Override
    public void delete(long id) {
studenRepo.deleteById(id);
    }

    @Override
    public Student findById(long id) {
        return studenRepo.findById(id).get();
    }

    @Override
    public List<Student> findByName(String name) {
        return studenRepo.findAllByName(name);
    }
}
