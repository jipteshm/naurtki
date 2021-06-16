package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.entity.Biller;

public interface BillerRepository extends JpaRepository<Biller,Long> {
}
