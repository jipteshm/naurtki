package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.BillerInfo;
import com.mohrait.dto.CategoryInfo;
import com.mohrait.entity.Biller;
import com.mohrait.entity.Category;

@Mapper(implementationPackage = "mapper.impl")
public interface BillerMapper {


    BillerMapper INSTANCE = Mappers.getMapper(BillerMapper.class);

    Biller billerInfoToBiller(BillerInfo billerInfo);

    @InheritInverseConfiguration
    BillerInfo billerToBillerInfo(Biller biller);
}
