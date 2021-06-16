package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.entity.Payment;
import com.mohra.entity.ProductItem;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

        Payment findPaymentByProductItemAndDeletedFalse(ProductItem productItem);
}
