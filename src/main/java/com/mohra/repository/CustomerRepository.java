package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mohra.entity.Customer;
import com.mohra.entity.Vendor;

/*
 * Created by Suresh Stalin on 02 / Nov / 2020.
 */

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCustomerCode(String customerCode);

    @Query("select c from Customer c where c.user.id in (Select u.id from User u where u.mobileNo = :mobileNo)")
    Customer findCustomerByMobileNo(@Param("mobileNo") String mobileNo);
}
