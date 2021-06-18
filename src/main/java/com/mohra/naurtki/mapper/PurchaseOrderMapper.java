package com.mohra.naurtki.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.naurtki.dto.ProductItemInfo;
import com.mohra.naurtki.dto.PurchaseOrderInfo;
import com.mohra.naurtki.entity.ProductItem;
import com.mohra.naurtki.entity.PurchaseOrder;

@Mapper(implementationPackage = "mapper.impl")
public interface PurchaseOrderMapper {

    PurchaseOrderMapper INSTANCE =  Mappers.getMapper(PurchaseOrderMapper.class);
    PurchaseOrder purchaseOrderInfoToPurchaseOrder(PurchaseOrderInfo purchaseOrderInfo);
    @InheritInverseConfiguration
    PurchaseOrderInfo purchaseOrderToPurchaseOrderInfo(PurchaseOrder purchaseOrder);
}
