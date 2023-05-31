package com.pesapauniversity.controllers;

import com.pesapauniversity.models.Student;
import com.pesapauniversity.services.StudentService;
import com.pesapauniversity.utils.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/student")
public class StudentValidationController {
    private TransactionResponse transactionResponse;
    private StudentService studentService;
    @Autowired
    public StudentValidationController(TransactionResponse transactionResponse, StudentService studentService){
        this.studentService = studentService;
        this.transactionResponse = transactionResponse;
    }
    @GetMapping("/validate")
    public ResponseEntity<HashMap<String,Object>> validatePayment(@RequestBody Student studentValidationRequest) {
        // Process the validation request
        if(studentValidationRequest.getStudentId()<1) {
            return ResponseEntity.badRequest().body(transactionResponse.genericResponse("Bad Request", "Please check student ID"));
        }
        /*Check if response is null || Send validation response */
        Student studentValidationResponse = studentService.getStudentById(studentValidationRequest.getStudentId());
        if(studentValidationResponse.getStudentId() <1){
           return  ResponseEntity.ok(transactionResponse.genericResponse("success", "No student exist with the provided ID"));
        }
        return ResponseEntity.ok(transactionResponse.genericResponse("Success",studentValidationResponse));
    }
}
