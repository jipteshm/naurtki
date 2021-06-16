package com.mohra.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.dto.ProductItemInfo;
import com.mohra.dto.PurchaseOrderInfo;
import com.mohra.entity.ProductItem;
import com.mohra.entity.PurchaseOrder;

@Mapper(implementationPackage = "mapper.impl")
public interface PurchaseOrderMapper {

    PurchaseOrderMapper INSTANCE =  Mappers.getMapper(PurchaseOrderMapper.class);
    PurchaseOrder purchaseOrderInfoToPurchaseOrder(PurchaseOrderInfo purchaseOrderInfo);
    @InheritInverseConfiguration
    PurchaseOrderInfo purchaseOrderToPurchaseOrderInfo(PurchaseOrder purchaseOrder);
}
