package com.pesapauniversity.services;

import com.pesapauniversity.models.Student;
import com.pesapauniversity.reposotories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentValidationService {
    private final ValidationRepository validationRepository;

    @Autowired
    public StudentValidationService(ValidationRepository validationRepository) {
        this.validationRepository = validationRepository;
    }

    public List<Student> getAllPayments() {
        return validationRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> student = validationRepository.findById(studentId);
        Student studentResponse = student.get();
        if(student.isEmpty()){
            return null;
        }
        System.out.println("===="+studentResponse.getStudentId());
        return studentResponse;
    }

    public Student submitPayment(FeePa student) {
        return validationRepository.save(student);
    }
}
