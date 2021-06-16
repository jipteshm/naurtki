package com.mohrait.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Offer;

import java.util.List;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

public interface OfferRepository extends JpaRepository<Offer,Long> {

    List<Offer> findOfferByIdIn(List<Long> ids);
}
