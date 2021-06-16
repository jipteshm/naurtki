package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.entity.AppEntityCode;
import com.mohra.entity.Employee;

/*
 * Created by Suresh Stalin on 20 / Oct / 2020.
 */

public interface AppEntityCodeRepository extends JpaRepository<AppEntityCode,Long> {
    AppEntityCode findByCode(String code);
}
