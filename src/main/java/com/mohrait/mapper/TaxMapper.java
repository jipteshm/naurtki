package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.TaxInfo;
import com.mohrait.dto.UserInfo;
import com.mohrait.entity.Tax;
import com.mohrait.entity.User;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface TaxMapper {

    TaxMapper INSTANCE =  Mappers.getMapper(TaxMapper.class);
    Tax taxInfoToTax(TaxInfo taxInfo);
    @InheritInverseConfiguration
    TaxInfo taxToTaxInfo(Tax tax);

}
