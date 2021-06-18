package com.mohra.naurtki.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohra.naurtki.common.CodeGenerator;
import com.mohra.naurtki.common.TaxCalculation;
import com.mohra.naurtki.common.TaxCalculationInput;
import com.mohra.naurtki.common.TaxCalculationResponse;
import com.mohra.naurtki.common.staticdata.CodeType;
import com.mohra.naurtki.common.staticdata.PurchaseOrderStatus;
import com.mohra.naurtki.dto.PurchaseOrderInfo;
import com.mohra.naurtki.entity.Category;
import com.mohra.naurtki.entity.PurchaseOrder;
import com.mohra.naurtki.entity.Tax;
import com.mohra.naurtki.entity.Vendor;
import com.mohra.naurtki.mapper.PurchaseOrderMapper;
import com.mohra.naurtki.messages.ResponseMessage;
import com.mohra.naurtki.repository.CategoryRepository;
import com.mohra.naurtki.repository.PurchaseOrderRepository;
import com.mohra.naurtki.repository.TaxRepository;
import com.mohra.naurtki.repository.VendorRepository;
import com.mohra.naurtki.service.BaseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService extends BaseService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private TaxRepository taxRepository;

    @Autowired
    private TaxCalculation taxCalculation;

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseMessage<PurchaseOrderInfo> save(PurchaseOrderInfo purchaseOrderInfo) {

        PurchaseOrder purchaseOrder = PurchaseOrderMapper.INSTANCE
                .purchaseOrderInfoToPurchaseOrder(purchaseOrderInfo);
        if (purchaseOrderInfo.getId() == null) {
            Category category = categoryRepository.findById(purchaseOrderInfo.getCategory().getId()).orElse(null);
            purchaseOrder.setCategory(category);
            Vendor vendor = vendorRepository.getOne(purchaseOrder.getVendor().getId());
            purchaseOrder.setVendor(vendor);
            Tax tax = taxRepository.getOne(purchaseOrder.getTax().getId());
            purchaseOrder.setTax(tax);
            String purchaseOrderCode = codeGenerator.newCode(CodeType.PURCHASE_ORDER_CODE);
            purchaseOrder.setPurchaseOrderCode(purchaseOrderCode);
//            purchaseOrder.setPurchaseOrderStatus(PurchaseOrderStatus.PENDING);
        }
        TaxCalculationInput taxCalculationInput =
                new TaxCalculationInput(
                        purchaseOrder.getUnitPrice(), purchaseOrder.getTax().getTaxPercentage(), purchaseOrder.getQuantity());
        TaxCalculationResponse taxCalculationResponse
                = taxCalculation.calculateTax(taxCalculationInput);
        purchaseOrder.setTotalAmount(taxCalculationResponse.getTotalAmount());
        purchaseOrder.setGrandTotal(taxCalculationResponse.getGrandTotal());
        purchaseOrder.setTaxAmount(taxCalculationResponse.getTaxAmount());
        
        purchaseOrder.setPurchaseOrderStatus(PurchaseOrderStatus.INITIATED);
        
        PurchaseOrder newPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        PurchaseOrderInfo newPurchaseOrderInfo = PurchaseOrderMapper
                .INSTANCE.purchaseOrderToPurchaseOrderInfo(newPurchaseOrder);
        ResponseMessage<PurchaseOrderInfo> responseMessage = ResponseMessage.withResponseData(newPurchaseOrderInfo, "", "");
        return responseMessage;
    }

    @Override
    public ResponseMessage findResourceById(String id) throws Exception {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(Long.parseLong(id)).orElse(null);
        PurchaseOrderInfo purchaseOrderInfo = PurchaseOrderMapper.INSTANCE.purchaseOrderToPurchaseOrderInfo(purchaseOrder);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(purchaseOrderInfo, "", "");
        return responseMessage;
    }

    @Override
    public ResponseMessage findAll() throws Exception {
        List<PurchaseOrderInfo> purchaseOrderInfos = new ArrayList<>();
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            PurchaseOrderInfo purchaseOrderInfo = PurchaseOrderMapper.INSTANCE.purchaseOrderToPurchaseOrderInfo(purchaseOrder);
            purchaseOrderInfos.add(purchaseOrderInfo);
        }
        ResponseMessage responseMessage = ResponseMessage.withResponseData(purchaseOrderInfos, "", "");
        return responseMessage;
    }

//    public void findPurchaseOrderByVendorAndProductNameAndStatus(Long vendorId,String productName,
//                                                                 PurchaseOrderStatus purchaseOrderStatus) {
//        PurchaseOrder purchaseOrder
//    }
}
