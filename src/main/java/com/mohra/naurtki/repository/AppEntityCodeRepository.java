package com.mohra.naurtki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.naurtki.entity.AppEntityCode;
import com.mohra.naurtki.entity.Employee;

/*
 * Created by Suresh Stalin on 20 / Oct / 2020.
 */

public interface AppEntityCodeRepository extends JpaRepository<AppEntityCode,Long> {
    AppEntityCode findByCode(String code);
}
