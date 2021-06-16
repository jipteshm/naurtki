package com.mohra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohra.dto.OfferInfo;
import com.mohra.messages.ResponseMessage;
import com.mohra.service.bo.OfferService;

import javax.validation.Valid;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@RestController
@RequestMapping("api/private/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping
    public ResponseEntity<ResponseMessage<?>> save(@Valid @RequestBody OfferInfo offerInfo) {
        ResponseMessage responseMessage = offerService.save(offerInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<?>> get(@PathVariable String id) throws Exception{
        ResponseMessage responseMessage = offerService.findResourceById(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<?>> geAll() throws Exception{
        ResponseMessage responseMessage = offerService.findAll();
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }
}
