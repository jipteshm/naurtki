package com.mohra.naurtki.mapper.impl;

import javax.annotation.Generated;

import com.mohra.naurtki.dto.TaxInfo;
import com.mohra.naurtki.entity.Tax;
import com.mohra.naurtki.mapper.TaxMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T09:21:21+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class TaxMapperImpl implements TaxMapper {

    @Override
    public Tax taxInfoToTax(TaxInfo taxInfo) {
        if ( taxInfo == null ) {
            return null;
        }

        Tax tax = new Tax();

        tax.setId( taxInfo.getId() );
        tax.setHsnCode( taxInfo.getHsnCode() );
        tax.setTaxPercentage( taxInfo.getTaxPercentage() );
        tax.setTaxDescription( taxInfo.getTaxDescription() );

        return tax;
    }

    @Override
    public TaxInfo taxToTaxInfo(Tax tax) {
        if ( tax == null ) {
            return null;
        }

        TaxInfo taxInfo = new TaxInfo();

        taxInfo.setId( tax.getId() );
        taxInfo.setHsnCode( tax.getHsnCode() );
        taxInfo.setTaxPercentage( tax.getTaxPercentage() );
        taxInfo.setTaxDescription( tax.getTaxDescription() );

        return taxInfo;
    }
}
