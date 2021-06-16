package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.SystemCodes;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

public interface SystemCodeRepository extends JpaRepository<SystemCodes, Long> {

    SystemCodes findByCodeType(String codeType);
}
