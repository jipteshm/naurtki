package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Category;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
