package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.OfferInfo;
import com.mohra.dto.ProductInfo;
import com.mohra.entity.Offer;
import com.mohra.entity.Product;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface OfferMapper {

    OfferMapper INSTANCE =  Mappers.getMapper(OfferMapper.class);
    Offer offerInfoToOffer(OfferInfo offerInfo);
    @InheritInverseConfiguration
    OfferInfo offerToOfferInfo(Offer offer);
}
