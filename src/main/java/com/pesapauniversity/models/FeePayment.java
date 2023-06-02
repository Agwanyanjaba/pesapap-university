package com.pesapauniversity.models;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Entity
@Table(name = "payments")
public class FeePayment {

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_channel")
    private String paymentChannel;

    @Column(name = "payment_description")
    private String paymentDescription;

    @Column(name = "payment_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime paymentDate;


    // Default constructor (required by JPA)
    public FeePayment() {
    }

    // Getters and setters

    @Id
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "FeePayment Details{" +
                "paymentId=" + paymentId +
                ", studentId=" + studentId +
                ", amount=" + amount +
                ", paymentChannel='" + paymentChannel + '\'' +
                ", paymentDescription='" + paymentDescription + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}

