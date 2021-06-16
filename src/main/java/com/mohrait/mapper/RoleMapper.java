package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.RoleInfo;
import com.mohrait.entity.Employee;
import com.mohrait.entity.Role;

/*
 * Created by Suresh Stalin on 19 / Oct / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface RoleMapper {

    RoleMapper INSTANCE =  Mappers.getMapper(RoleMapper.class);
    Employee roleInfoToRole(RoleInfo roleInfo);
    @InheritInverseConfiguration
    RoleInfo roleToRoleInfo(Role role);

}
