package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.User;

/*
 * Created by Suresh Stalin on 10 / Nov / 2020.
 */

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailId(String emailId);
    User findByMobileNo(String mobileNo);
}
