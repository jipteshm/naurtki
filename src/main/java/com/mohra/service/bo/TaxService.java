package com.mohra.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohra.common.staticdata.Constants;
import com.mohra.dto.TaxInfo;
import com.mohra.entity.Tax;
import com.mohra.mapper.TaxMapper;
import com.mohra.messages.ResponseMessage;
import com.mohra.repository.TaxRepository;
import com.mohra.service.BaseService;
import com.mohra.service.BillingBaseService;

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
