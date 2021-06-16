package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Biller;

public interface BillerRepository extends JpaRepository<Biller,Long> {
}
