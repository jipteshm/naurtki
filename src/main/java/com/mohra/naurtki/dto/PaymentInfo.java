package com.mohra.naurtki.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.mohra.naurtki.entity.BaseObject;
import com.mohra.naurtki.entity.Biller;
import com.mohra.naurtki.entity.ProductItem;
import com.mohra.naurtki.entity.Tax;

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
