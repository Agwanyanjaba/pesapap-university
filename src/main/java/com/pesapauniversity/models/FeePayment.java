package com.pesapauniversity.models;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Entity
@Table(name = "payment")
public class FeePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "bank_channel")
    private String bankChannel;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    // Constructors, getters, and setters

    // Constructor with all fields
    public FeePayment(Long studentId, BigDecimal amount, String paymentMethod, String bankChannel, LocalDateTime paymentDate) {
        this.studentId = studentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.bankChannel = bankChannel;
        this.paymentDate = paymentDate;
    }

    // Default constructor (required by JPA)
    public FeePayment() {
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankChannel() {
        return bankChannel;
    }

    public void setBankChannel(String bankChannel) {
        this.bankChannel = bankChannel;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}

