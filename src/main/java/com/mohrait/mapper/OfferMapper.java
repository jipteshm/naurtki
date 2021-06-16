package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.OfferInfo;
import com.mohrait.dto.ProductInfo;
import com.mohrait.entity.Offer;
import com.mohrait.entity.Product;

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
