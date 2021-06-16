package com.mohrait.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.mohrait.entity.BaseObject;
import com.mohrait.entity.Customer;
import com.mohrait.entity.Product;

import java.util.List;

/*
 * Created by Suresh Stalin on 13 / Oct / 2020.
 */

@Getter
@Setter
public class BillerInfo extends BaseInfo {

    private String billNo;

    private CustomerInfo customer;

    private double grandTotal;

    private int quantity;

    private double totalTaxAmount;

}
