package com.pesapauniversity.reposotories;

import com.pesapauniversity.models.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeePaymentRepository extends JpaRepository<FeePayment, String> {
}
