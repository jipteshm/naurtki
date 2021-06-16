package com.mohra.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.mohra.entity.BaseObject;
import com.mohra.entity.Biller;
import com.mohra.entity.ProductItem;
import com.mohra.entity.Tax;

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
