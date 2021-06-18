package com.mohra.naurtki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.naurtki.common.staticdata.PurchaseOrderStatus;
import com.mohra.naurtki.entity.PurchaseOrder;
import com.mohra.naurtki.entity.Vendor;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {

    PurchaseOrder findPurchaseOrderByVendorAndProductNameAndPurchaseOrderStatus
            (Vendor vendor, String productName, PurchaseOrderStatus purchaseOrderStatus);
}
