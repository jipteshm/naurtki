package com.mohra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohra.dto.*;
import com.mohra.entity.Customer;
import com.mohra.entity.Product;
import com.mohra.entity.ProductItem;
import com.mohra.entity.User;
import com.mohra.messages.ResponseMessage;
import com.mohra.service.bo.BillerService;

import java.util.List;

@RestController
@RequestMapping("api/private/bills")
public class BillerController {

        @Autowired
        private BillerService billerService;

        @PostMapping("/payments")
        public ResponseEntity<ResponseMessage<?>> doPayment(@RequestBody PaymentRequest paymentRequest) {
            String mobileNo = paymentRequest.getCustomerMobileNo();
            List<String> productItemCode = paymentRequest.getProductItemCode();
            BillerInfo billerInfo = billerService.save(paymentRequest);
            ResponseMessage responseMessage = ResponseMessage.withResponseData(billerInfo,"","");
            return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
        }

    @PutMapping("/payments/cancel")
    public ResponseEntity<ResponseMessage<?>> doCancelPayment(@RequestBody PaymentRequest paymentRequest) {
        List<String> productItemCode = paymentRequest.getProductItemCode();
        List<PaymentInfo> paymentInfos = billerService.cancel(paymentRequest);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(paymentInfos,"","");
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }
}