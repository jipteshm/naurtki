package com.mohra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohra.entity.Tax;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

public interface TaxRepository extends JpaRepository<Tax,Long> {
}
