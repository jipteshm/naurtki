package com.mohra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohra.common.CodeGenerator;
import com.mohra.common.staticdata.CodeType;
import com.mohra.dto.PurchaseOrderInfo;
import com.mohra.entity.PurchaseOrder;
import com.mohra.mapper.PurchaseOrderMapper;
import com.mohra.messages.ResponseMessage;
import com.mohra.service.bo.PurchaseOrderService;

@RestController
@RequestMapping("api/private/product")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("/purchase")
    public ResponseEntity<ResponseMessage<?>> add(@RequestBody PurchaseOrderInfo purchaseOrderInfo) {
        ResponseMessage responseMessage  = purchaseOrderService.save(purchaseOrderInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping("/purchase")
    public ResponseEntity<ResponseMessage<?>> update(@RequestBody PurchaseOrderInfo purchaseOrderInfo) {
        ResponseMessage responseMessage  = purchaseOrderService.save(purchaseOrderInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/purchase")
    public ResponseEntity<ResponseMessage<?>> getAll() throws Exception{
        ResponseMessage responseMessage  = purchaseOrderService.findAll();
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/purchase/{id}")
    public ResponseEntity<ResponseMessage<?>> get(@PathVariable String id) throws Exception{
        ResponseMessage responseMessage  = purchaseOrderService.findResourceById(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }
}
