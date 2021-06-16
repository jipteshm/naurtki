package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohrait.entity.Organization;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
