package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.AppEntityCode;
import com.mohrait.entity.Employee;

/*
 * Created by Suresh Stalin on 20 / Oct / 2020.
 */

public interface AppEntityCodeRepository extends JpaRepository<AppEntityCode,Long> {
    AppEntityCode findByCode(String code);
}
