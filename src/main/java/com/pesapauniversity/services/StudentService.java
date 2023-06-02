package com.pesapauniversity.services;

import com.pesapauniversity.models.FeePayment;
import com.pesapauniversity.models.Student;
import com.pesapauniversity.reposotories.FeePaymentRepository;
import com.pesapauniversity.reposotories.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {
    private final ValidationRepository validationRepository;
    final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
    private final FeePaymentRepository feePaymentRepository;

    @Autowired
    public StudentService(ValidationRepository validationRepository, FeePaymentRepository feePaymentRepository) {
        this.validationRepository = validationRepository;
        this.feePaymentRepository = feePaymentRepository;
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> student = validationRepository.findById(studentId);
        if(student.isPresent()){
            Student studentResponse = student.get();
            LOGGER.info("===VALIDATION REQUEST for :: {}",studentResponse.getStudentId(),"received");
            return studentResponse;
        }
        else {
            LOGGER.warn("===[Student details not found");
            return null;
        }
    }

    public HashMap<Object, Object> submitPayment(FeePayment feePayment) {

        try {
            FeePayment savedPayment = feePaymentRepository.save(feePayment);
            //Save operation was successful
            Student payingStudent = getStudentById(feePayment.getStudentId());
            HashMap<Object, Object> paymentResponse = new LinkedHashMap<>();
            paymentResponse.put("paymentId", savedPayment.getPaymentId());
            paymentResponse.put("studentId",savedPayment.getStudentId());
            paymentResponse.put("studentName", payingStudent.getFirstName()+" "+payingStudent.getLastName());
            paymentResponse.put("amountPaid", savedPayment.getAmount());
            paymentResponse.put("paymentDescription", savedPayment.getPaymentDescription());

            return paymentResponse;

        } catch (DataIntegrityViolationException e) {
            // Save operation failed due to constraints or validation errors
            LOGGER.error("===[ERROR on payment submission"+e.getMessage());
            return null;
        }

    }
}
