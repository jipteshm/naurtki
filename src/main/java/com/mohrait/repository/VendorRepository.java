package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Employee;
import com.mohrait.entity.Vendor;

/*
 * Created by Suresh Stalin on 02 / Nov / 2020.
 */

public interface VendorRepository extends JpaRepository<Vendor, Long>  {

        Vendor findByVendorCode(String vendorCode);
}
