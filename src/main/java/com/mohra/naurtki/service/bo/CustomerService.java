package com.mohra.naurtki.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohra.naurtki.dto.CustomerInfo;
import com.mohra.naurtki.entity.Customer;
import com.mohra.naurtki.exception.ResourceNotFoundException;
import com.mohra.naurtki.mapper.CustomerMapper;
import com.mohra.naurtki.messages.ResponseMessage;
import com.mohra.naurtki.repository.CustomerRepository;

import javax.transaction.Transactional;

/*
 * Created by Suresh Stalin on 02 / Nov / 2020.
 */

@Service
public class CustomerService extends UserService {

    private final CustomerRepository repository;

    @Autowired
    CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Override
    public ResponseMessage findResourceById(String id) throws Exception {
        Customer customer = null;
        if(id.contains("CUS")) {
            customer = repository.findByCustomerCode(id);
        }
        else {
            customer = repository.findById(Long.parseLong(id)).orElse(null);
        }
        ResponseMessage responseMessage = new ResponseMessage();
        if (customer != null) {
            CustomerInfo customerDTO = CustomerMapper.INSTANCE.customerToCustomerInfo(customer);
            responseMessage.setResponseClassType(customerDTO);
        } else {
            throw new ResourceNotFoundException("Customer not found");
        }
        return responseMessage;
    }
}
