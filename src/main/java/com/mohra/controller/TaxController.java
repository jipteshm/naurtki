package com.mohra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohra.dto.TaxInfo;
import com.mohra.messages.ResponseMessage;
import com.mohra.service.bo.TaxService;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@RestController
@RequestMapping("api/private/taxes")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping
    public ResponseEntity<ResponseMessage<?>> save(@Valid @RequestBody TaxInfo taxInfo) {
        ResponseMessage responseMessage  = taxService.save(taxInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<?>> get(@PathVariable String id) throws Exception {
        ResponseMessage responseMessage = taxService.findResourceById(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseMessage<?>> getAll() throws Exception {
        ResponseMessage responseMessage = taxService.findAll();
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }
}