package com.mohra.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohra.dto.VendorInfo;
import com.mohra.entity.Vendor;
import com.mohra.exception.ResourceNotFoundException;
import com.mohra.mapper.VendorMapper;
import com.mohra.messages.ResponseMessage;
import com.mohra.repository.VendorRepository;

import javax.transaction.Transactional;
/*
 * Created by Suresh Stalin on 02 / Nov / 2020.
 */


@Service
public class VendorService extends UserService {

    private final VendorRepository repository;

    @Autowired
    VendorService(VendorRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Override
    public ResponseMessage findResourceById(String id) throws Exception {
        Vendor vendor = null;
        if (id.contains("VEN")) {
            vendor = repository.findByVendorCode(id);
        } else {
            vendor = repository.findById(Long.parseLong(id)).orElse(null);
        }
        ResponseMessage responseMessage = new ResponseMessage();
        if (vendor != null) {
            VendorInfo vendorInfo = VendorMapper.INSTANCE.vendorToVendorInfo(vendor);
            responseMessage.setResponseClassType(vendorInfo);
        } else {
            throw new ResourceNotFoundException("Vendor not found");
        }
        return responseMessage;
    }
}
