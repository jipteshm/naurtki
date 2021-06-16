package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.common.staticdata.PurchaseOrderStatus;
import com.mohrait.entity.PurchaseOrder;
import com.mohrait.entity.Vendor;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {

    PurchaseOrder findPurchaseOrderByVendorAndProductNameAndPurchaseOrderStatus
            (Vendor vendor, String productName, PurchaseOrderStatus purchaseOrderStatus);
}
