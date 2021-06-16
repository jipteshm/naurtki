package com.mohrait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohrait.entity.Role;
import com.mohrait.entity.User;

import java.util.Optional;


/*
 * Created by Suresh Stalin on 17 / Oct / 2020.
 */

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(String name);

    @Query(value = "select * from user_role where role_id = ?1",nativeQuery = true)
    Object[] getSuperAdmin(long roleId);
}
