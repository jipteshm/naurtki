package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.CustomerInfo;
import com.mohra.entity.Customer;

/*
 * Created by Suresh Stalin on 18 / Oct / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface CustomerMapper {

    CustomerMapper INSTANCE =  Mappers.getMapper(CustomerMapper.class);
    Customer customerInfoToCustomer(CustomerInfo customerInfo);
    @InheritInverseConfiguration
    CustomerInfo customerToCustomerInfo(Customer customer);
}
