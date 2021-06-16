package com.mohrait.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohrait.entity.Employee;

/*
 * Created by Suresh Stalin on 20 / Oct / 2020.
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

        Employee findByEmployeeCode(String employeeCode);
}
