package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.CustomerInfo;
import com.mohra.dto.ProductInfo;
import com.mohra.entity.Customer;
import com.mohra.entity.Product;

/*
 * Created by Suresh Stalin on 22 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface ProductMapper {

    ProductMapper INSTANCE =  Mappers.getMapper(ProductMapper.class);
    Product productInfoToProduct(ProductInfo productInfo);
    @InheritInverseConfiguration
    ProductInfo productToProductInfo(Product product);
}
