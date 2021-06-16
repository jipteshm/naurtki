package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.VendorInfo;
import com.mohrait.entity.Vendor;

/*
 * Created by Suresh Stalin on 18 / Oct / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    Vendor vendorInfoToVendor(VendorInfo vendorInfo);
    @InheritInverseConfiguration
    VendorInfo vendorToVendorInfo(Vendor vendor);


}
