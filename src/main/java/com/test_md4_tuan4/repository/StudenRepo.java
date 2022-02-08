package com.test_md4_tuan4.repository;

import com.test_md4_tuan4.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface StudenRepo extends PagingAndSortingRepository<Student, Long> {
    @Query(value = "select s from Student s where s.name like concat('%' ,:name, '%')")
    List<Student> findAllByName(@Param("name") String name);
}
