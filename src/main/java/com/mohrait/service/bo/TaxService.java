package com.mohrait.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohrait.common.staticdata.Constants;
import com.mohrait.dto.TaxInfo;
import com.mohrait.entity.Tax;
import com.mohrait.mapper.TaxMapper;
import com.mohrait.messages.ResponseMessage;
import com.mohrait.repository.TaxRepository;
import com.mohrait.service.BaseService;
import com.mohrait.service.BillingBaseService;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@Service
public class TaxService extends BaseService {


    @Autowired
    private TaxRepository taxRepository;

    /*
     * This method for adding new Tax Records and updating existing Tax Records
     */
    public ResponseMessage save(TaxInfo taxInfo) {
        Tax tax = TaxMapper.INSTANCE.taxInfoToTax(taxInfo);
        Tax newTax = taxRepository.save(tax);
        TaxInfo newTaxInfoResponse = TaxMapper.INSTANCE.taxToTaxInfo(newTax);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(newTaxInfoResponse,"Tax saved successfully",Constants.INFO_TYPE);
        return responseMessage;
    }

    @Override
    public ResponseMessage findResourceById(String id) throws Exception {
        Tax tax = taxRepository.findById(Long.parseLong(id)).orElse(null);
        TaxInfo newTaxInfoResponse = TaxMapper.INSTANCE.taxToTaxInfo(tax);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(newTaxInfoResponse,"Tax saved successfully",Constants.INFO_TYPE);
        return responseMessage;
    }

    @Override
    public ResponseMessage findAll() throws Exception {
        List<Tax> taxes = taxRepository.findAll();
        List<TaxInfo> taxInfos = new ArrayList<>();
        for (Tax tax: taxes) {
            TaxInfo taxInfo = TaxMapper.INSTANCE.taxToTaxInfo(tax);
            taxInfos.add(taxInfo);
        }
        ResponseMessage responseMessage = ResponseMessage.withResponseData(taxInfos,Constants.SUCCESS_STATUS, Constants.INFO_TYPE);
        return responseMessage;
    }
}
