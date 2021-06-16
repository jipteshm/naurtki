package com.mohrait.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.mohrait.entity.BaseObject;
import com.mohrait.entity.Biller;
import com.mohrait.entity.ProductItem;
import com.mohrait.entity.Tax;

@Getter
@Setter
public class PaymentInfo extends BaseObject {

    private BillerInfo biller;

    private ProductItemInfo productItem;

    private Tax tax;

    private double price;

    private double totalPrice;

    private double taxAmount;

    private long productId;

}
