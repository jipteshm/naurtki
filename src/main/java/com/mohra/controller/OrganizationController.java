package com.mohra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohra.dto.OrganizationInfo;
import com.mohra.messages.ResponseMessage;
import com.mohra.service.bo.OrganizationService;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

@RestController
@RequestMapping("api/public/orgs")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<ResponseMessage<?>> saveOrg(@RequestBody OrganizationInfo organizationInfo) throws Exception{
        ResponseMessage responseMessage = organizationService.save(organizationInfo);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }
}