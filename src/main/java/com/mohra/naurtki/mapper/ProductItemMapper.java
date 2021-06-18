package com.mohra.naurtki.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.naurtki.dto.ProductItemInfo;
import com.mohra.naurtki.dto.UserInfo;
import com.mohra.naurtki.entity.ProductItem;
import com.mohra.naurtki.entity.User;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface ProductItemMapper {

    ProductItemMapper INSTANCE =  Mappers.getMapper(ProductItemMapper.class);
    ProductItem productItemInfoToProductItem(ProductItemInfo productItemInfo);
    @InheritInverseConfiguration
    ProductItemInfo productItemToProductItemInfo(ProductItem productItem);

}
