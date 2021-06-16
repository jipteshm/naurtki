package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.common.staticdata.PurchaseOrderStatus;
import com.mohra.entity.PurchaseOrder;
import com.mohra.entity.Vendor;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {

    PurchaseOrder findPurchaseOrderByVendorAndProductNameAndPurchaseOrderStatus
            (Vendor vendor, String productName, PurchaseOrderStatus purchaseOrderStatus);
}
