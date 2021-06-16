package com.mohra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohra.dto.ProductInfo;
import com.mohra.dto.ProductItemInfo;
import com.mohra.entity.Product;
import com.mohra.entity.ProductItem;
import com.mohra.messages.ResponseMessage;
import com.mohra.service.bo.ProductItemService;
import com.mohra.service.bo.ProductService;

import javax.validation.Valid;

/*
 * Created by Suresh Stalin on 22 / Nov / 2020.
 */

@RestController
@RequestMapping("api/private/products")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductItemService productItemService;

    @PostMapping
    public ResponseEntity<ResponseMessage<?>> add(@Valid @RequestBody ProductInfo productInfo) {
        ResponseMessage responseMessage =  productService.add(productInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseMessage<?>> update(@RequestBody ProductInfo productInfo) {
        ResponseMessage responseMessage =  productService.update(productInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<?>> get(@PathVariable String id) throws Exception {
        ResponseMessage responseMessage = productService.findResourceById(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseMessage<?>> getAll() throws Exception {
        ResponseMessage responseMessage = productService.findAll();
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

//    @PostMapping("/items")
//    public ResponseEntity<ResponseMessage<?>> saveProductItems(@RequestBody ProductItemInfo productItemInfo) {
//        ResponseMessage responseMessage =  productItemService.save(productItemInfo);
//        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
//    }
    @PostMapping("/items/{id}")
    public ResponseEntity<ResponseMessage<?>> getProductItem(@PathVariable String id) throws Exception {
        ResponseMessage responseMessage =  productItemService.findResourceById(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<ResponseMessage<?>> getAllProductItems() throws Exception {
        ResponseMessage responseMessage =  productItemService.findAll();
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }
}
