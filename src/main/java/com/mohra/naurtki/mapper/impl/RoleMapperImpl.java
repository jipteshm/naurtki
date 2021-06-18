package com.mohra.naurtki.mapper.impl;

import javax.annotation.Generated;

import com.mohra.naurtki.dto.RoleInfo;
import com.mohra.naurtki.entity.Employee;
import com.mohra.naurtki.entity.Role;
import com.mohra.naurtki.mapper.RoleMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T09:21:20+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Employee roleInfoToRole(RoleInfo roleInfo) {
        if ( roleInfo == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( roleInfo.getId() );

        return employee;
    }

    @Override
    public RoleInfo roleToRoleInfo(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleInfo roleInfo = new RoleInfo();

        roleInfo.setId( role.getId() );
        roleInfo.setName( role.getName() );
        roleInfo.setDescription( role.getDescription() );

        return roleInfo;
    }
}
