package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.ProductItemInfo;
import com.mohrait.dto.UserInfo;
import com.mohrait.entity.ProductItem;
import com.mohrait.entity.User;

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
