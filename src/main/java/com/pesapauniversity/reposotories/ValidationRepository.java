package com.pesapauniversity.reposotories;

import com.pesapauniversity.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ValidationRepository extends JpaRepository<Student, Long> {
}
