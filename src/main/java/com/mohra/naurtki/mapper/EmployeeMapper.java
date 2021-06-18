package com.mohra.naurtki.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.naurtki.dto.EmployeeInfo;
import com.mohra.naurtki.entity.Employee;

/*
 * Created by Suresh Stalin on 17 / Oct / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface EmployeeMapper {


    EmployeeMapper INSTANCE =  Mappers.getMapper(EmployeeMapper.class);
    Employee employeeInfoToEmployee(EmployeeInfo employeeInfo);
    @InheritInverseConfiguration
    EmployeeInfo employeeToEmployeeInfo(Employee employee);

//    @AfterMapping
//    default void afterMapping(@MappingTarget Employee employee, EmployeeDto employeeDto) {
//        employeeDto.setId(employee.getId());
//        employeeDto.setFlowType(Constants.EMPLOYEE_FLOW_TYPE);
//    }
}
