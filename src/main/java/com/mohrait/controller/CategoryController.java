package com.mohrait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mohrait.dto.CategoryInfo;
import com.mohrait.dto.TaxInfo;
import com.mohrait.messages.ResponseMessage;
import com.mohrait.service.bo.CategoryService;

import javax.validation.Valid;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@RestController
@RequestMapping("api/private/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ResponseMessage<?>> save(@Valid @RequestBody CategoryInfo categoryInfo) {
        ResponseMessage responseMessage  = categoryService.save(categoryInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<?>> get(@PathVariable String id) throws Exception {
        ResponseMessage responseMessage = categoryService.findResourceById(id);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseMessage<?>> getAll() throws Exception {
        ResponseMessage responseMessage = categoryService.findAll();
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.OK);
    }
}
