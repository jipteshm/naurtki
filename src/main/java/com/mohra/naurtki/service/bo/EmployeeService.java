package com.mohra.naurtki.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mohra.naurtki.dto.EmployeeInfo;
import com.mohra.naurtki.entity.Employee;
import com.mohra.naurtki.exception.ResourceNotFoundException;
import com.mohra.naurtki.mapper.EmployeeMapper;
import com.mohra.naurtki.messages.ResponseMessage;
import com.mohra.naurtki.repository.EmployeeRepository;

/*
 * Created by Suresh Stalin on 02 / Nov / 2020.
 */

@Service
public class EmployeeService  extends UserService{

    private final EmployeeRepository repository;

    @Autowired
    EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseMessage findResourceById(String id) throws Exception {

        UserDetails userDetails = getContext();

        Employee employee = null;
        if(id.contains("EMP")) {
            employee = repository.findByEmployeeCode(id);
        }
        else {
            employee = repository.findById(Long.parseLong(id)).orElse(null);
        }
        ResponseMessage responseMessage = new ResponseMessage();
        if (employee != null) {
            EmployeeInfo employeeDTO = EmployeeMapper.INSTANCE.employeeToEmployeeInfo(employee);
            responseMessage.setResponseClassType(employeeDTO);
        } else {
            throw new ResourceNotFoundException("Employee not found");
        }
        return responseMessage;
    }
}
