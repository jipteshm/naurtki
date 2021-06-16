package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.ProductItemInfo;
import com.mohrait.dto.PurchaseOrderInfo;
import com.mohrait.entity.ProductItem;
import com.mohrait.entity.PurchaseOrder;

@Mapper(implementationPackage = "mapper.impl")
public interface PurchaseOrderMapper {

    PurchaseOrderMapper INSTANCE =  Mappers.getMapper(PurchaseOrderMapper.class);
    PurchaseOrder purchaseOrderInfoToPurchaseOrder(PurchaseOrderInfo purchaseOrderInfo);
    @InheritInverseConfiguration
    PurchaseOrderInfo purchaseOrderToPurchaseOrderInfo(PurchaseOrder purchaseOrder);
}
