package com.pesapauniversity.controllers;

import com.pesapauniversity.models.FeePayment;
import com.pesapauniversity.services.StudentService;
import com.pesapauniversity.utils.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1/api/student")
public class PaymentNotificationController {
    private TransactionResponse transactionResponse;
    private StudentService studentService;
    final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public PaymentNotificationController(TransactionResponse transactionResponse, StudentService studentService){
        this.studentService = studentService;
        this.transactionResponse = transactionResponse;
    }

    @PostMapping("/notification")
    public ResponseEntity<HashMap<String,Object>> notification(@RequestBody FeePayment feePayment) {
        LOGGER.info("===[FEE_PAYMENT Notification Received :: {}",feePayment.toString());
        // Process the payment request
        if(feePayment.getStudentId()<1) {
            return ResponseEntity.badRequest().body(transactionResponse.genericResponse("Bad Request", "Please check student ID"));
        }

        //send the response
        if(studentService.submitPayment(feePayment) ==null){
            String errorMessage = "An internal server error occurred.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(transactionResponse.genericResponse("Failed",errorMessage));
        }
        else {
            // Send payment received response
            return ResponseEntity.ok(transactionResponse.genericResponse("Success", studentService.submitPayment(feePayment)));
        }
    }
}
