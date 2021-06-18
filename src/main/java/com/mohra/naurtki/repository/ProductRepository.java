package com.mohra.naurtki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.naurtki.entity.Employee;
import com.mohra.naurtki.entity.Product;

/*
 * Created by Suresh Stalin on 22 / Nov / 2020.
 */

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
