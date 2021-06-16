package com.mohra.dto;

import com.mohra.common.staticdata.StockStatus;

import lombok.Getter;
import lombok.Setter;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

@Getter
@Setter
public class ProductItemInfo extends BaseInfo {

    private String productItemCode;

    private ProductInfo productInfo;

    private StockStatus stockStatus;

}
