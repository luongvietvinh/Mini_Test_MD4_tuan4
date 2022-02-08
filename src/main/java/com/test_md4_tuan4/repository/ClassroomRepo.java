package com.test_md4_tuan4.repository;

import com.test_md4_tuan4.model.Classroom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassroomRepo extends PagingAndSortingRepository<Classroom,Long> {
}
