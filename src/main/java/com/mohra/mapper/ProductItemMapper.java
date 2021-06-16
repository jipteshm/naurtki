package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.ProductItemInfo;
import com.mohra.dto.UserInfo;
import com.mohra.entity.ProductItem;
import com.mohra.entity.User;

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
