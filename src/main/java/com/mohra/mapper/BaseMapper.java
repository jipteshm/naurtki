package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.BaseInfo;
import com.mohra.entity.BaseObject;

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
