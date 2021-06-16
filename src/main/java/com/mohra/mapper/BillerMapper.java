package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.BillerInfo;
import com.mohra.dto.CategoryInfo;
import com.mohra.entity.Biller;
import com.mohra.entity.Category;

@Mapper(implementationPackage = "mapper.impl")
public interface BillerMapper {


    BillerMapper INSTANCE = Mappers.getMapper(BillerMapper.class);

    Biller billerInfoToBiller(BillerInfo billerInfo);

    @InheritInverseConfiguration
    BillerInfo billerToBillerInfo(Biller biller);
}
