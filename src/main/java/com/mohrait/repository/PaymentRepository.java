package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Payment;
import com.mohrait.entity.ProductItem;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

        Payment findPaymentByProductItemAndDeletedFalse(ProductItem productItem);
}
