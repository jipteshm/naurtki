package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.entity.Employee;
import com.mohra.entity.Vendor;

/*
 * Created by Suresh Stalin on 02 / Nov / 2020.
 */

public interface VendorRepository extends JpaRepository<Vendor, Long>  {

        Vendor findByVendorCode(String vendorCode);
}
