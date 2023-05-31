package com.pesapauniversity.controllers;

import com.pesapauniversity.models.Student;
import com.pesapauniversity.services.StudentValidationService;
import com.pesapauniversity.utils.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/student")
public class StudentNotificationController {
    private TransactionResponse transactionResponse;
    private StudentValidationService studentValidationService;

    @Autowired
    public StudentNotificationController(TransactionResponse transactionResponse, StudentValidationService studentValidationService){
        this.studentValidationService = studentValidationService;
        this.transactionResponse = transactionResponse;
    }

    @PostMapping("/validate")
    public ResponseEntity<HashMap<String,Object>> validatePayment(@RequestBody Student studentValidationRequest) {
        // Process the payment request

        if(studentValidationRequest.getStudentId()<1) {
            return ResponseEntity.badRequest().body(transactionResponse.genericResponse("Bad Request", "Please check student ID"));
        }
        Student studentValidationResponse = studentValidationService.getStudentById(studentValidationRequest.getStudentId());
        // Send validation response
        //add check if student ID is null
        return ResponseEntity.ok(transactionResponse.genericResponse("Success",studentValidationResponse));
    }
}
