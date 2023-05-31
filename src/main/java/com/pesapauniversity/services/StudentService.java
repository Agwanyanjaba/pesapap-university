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

    public List<Student> getAllPayments() {
        return validationRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> student = validationRepository.findById(studentId);
        Student studentResponse = student.get();
        if(student.isEmpty()){
            LOGGER.warn("===[Student details not found");
            return null;
        }
        LOGGER.info("==="+studentResponse.getStudentId());
        return studentResponse;
    }

    public HashMap<Object, Object> submitPayment(FeePayment feePayment) {

        try {
            FeePayment savedPayment = feePaymentRepository.save(feePayment);
            //Save operation was successful

            HashMap<Object, Object> paymentResponse = new LinkedHashMap<>();
            paymentResponse.put("paymentId", savedPayment.getId());
            paymentResponse.put("studentId",savedPayment.getStudentId());
            paymentResponse.put("amountPaid", savedPayment.getAmount());
            paymentResponse.put("paymentDate", savedPayment.getPaymentDate());
            return paymentResponse;

        } catch (DataIntegrityViolationException e) {
            // Save operation failed due to constraints or validation errors
            LOGGER.error("===["+e.getMessage());
            return null;
        }

    }
}
