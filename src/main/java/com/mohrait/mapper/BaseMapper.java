package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.BaseInfo;
import com.mohrait.entity.BaseObject;

/*
 * Created by Suresh Stalin on 17 / Oct / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface BaseMapper {

    BaseMapper INSTANCE =  Mappers.getMapper(BaseMapper.class);
    BaseObject baseInfoToBaseObject(BaseInfo baseInfo);
    @InheritInverseConfiguration
    BaseInfo baseObjectToBaseInfo(BaseObject baseObject);
}
