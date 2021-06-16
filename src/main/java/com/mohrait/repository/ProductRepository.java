package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Employee;
import com.mohrait.entity.Product;

/*
 * Created by Suresh Stalin on 22 / Nov / 2020.
 */

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
