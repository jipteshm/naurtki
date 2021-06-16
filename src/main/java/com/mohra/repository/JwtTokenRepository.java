package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.entity.JwtToken;

/*
 * Created by Suresh Stalin on 10 / Nov / 2020.
 */

public interface JwtTokenRepository extends JpaRepository<JwtToken, Long> {

    JwtToken findByUserName(String userName);
}
