package com.mohra.naurtki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.naurtki.entity.ProductItem;

import java.util.List;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    List<ProductItem> findProductItemByProductItemCodeIn(List<String> productItemCodes);
}
