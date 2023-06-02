package com.pesapauniversity.controllers;

import com.pesapauniversity.models.Student;
import com.pesapauniversity.services.StudentService;
import com.pesapauniversity.utils.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/api/student")
public class StudentValidationController {
    private TransactionResponse transactionResponse;
    private StudentService studentService;
    final Logger LOGGER = LoggerFactory.getLogger(StudentValidationController.class);
    @Autowired
    public StudentValidationController(TransactionResponse transactionResponse, StudentService studentService){
        this.studentService = studentService;
        this.transactionResponse = transactionResponse;
    }
    @PostMapping("/validate")
    public ResponseEntity<HashMap<String,Object>> validatePayment(@RequestBody Student studentValidationRequest) {
        // Process the validation request
        if(studentValidationRequest.getStudentId()<1) {
            return ResponseEntity.badRequest().body(transactionResponse.genericResponse("Bad Request", "Please check student ID"));
        }
        /*Check if response is null || Send validation response */
        Student studentValidationResponse = studentService.getStudentById(studentValidationRequest.getStudentId());
        LOGGER.info("=== [Validation Response sent");
        if(studentValidationResponse !=null ){
            return ResponseEntity.ok(transactionResponse.genericResponse("Success",studentValidationResponse));
        }
        else{
            String noRecordFound = "No student exist with the provided ID";
            return  ResponseEntity.ok(transactionResponse.genericResponse("success", new HashMap<>().put("Response", noRecordFound)));
        }

    }
}
