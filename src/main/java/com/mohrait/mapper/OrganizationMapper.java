package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.OrganizationInfo;
import com.mohrait.dto.UserInfo;
import com.mohrait.entity.Organization;
import com.mohrait.entity.User;

/*
 * Created by Suresh Stalin on 24 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface OrganizationMapper {

    OrganizationMapper INSTANCE =  Mappers.getMapper(OrganizationMapper.class);
    Organization organizationInfoToOrganization(OrganizationInfo organizationInfo);
    @InheritInverseConfiguration
    OrganizationInfo organizationToOrganizationInfo(Organization organization);
}
