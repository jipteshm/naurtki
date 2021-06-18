package com.mohra.naurtki.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.naurtki.dto.RoleInfo;
import com.mohra.naurtki.entity.Employee;
import com.mohra.naurtki.entity.Role;

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
