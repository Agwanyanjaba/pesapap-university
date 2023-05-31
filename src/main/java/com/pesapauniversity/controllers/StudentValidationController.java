package com.pesapauniversity.controllers;

import com.pesapauniversity.models.Student;
import com.pesapauniversity.utils.TransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/student")
public class StudentValidationController {
    private TransactionResponse transactionResponse;



    @PostMapping("/validate")
    public ResponseEntity<HashMap<String,Object>> validatePayment(@RequestBody Student studentValidationRequest) {
        // Process the payment request
        String studentId = String.valueOf(studentValidationRequest.getStudentId());
        if(studentId.length()<1) {

            return ResponseEntity.badRequest().body(validationResponse.genericResponse("Bad Request", "Please check student ID"));
        }

        // Send validation request to Pe University via http call

        return ResponseEntity.ok(validationResponse.genericResponse("Success","Fee payment was successful"));
    }
}
