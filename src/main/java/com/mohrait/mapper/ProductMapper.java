package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.CustomerInfo;
import com.mohrait.dto.ProductInfo;
import com.mohrait.entity.Customer;
import com.mohrait.entity.Product;

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
