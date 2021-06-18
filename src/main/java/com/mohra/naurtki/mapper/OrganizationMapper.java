package com.mohra.naurtki.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.naurtki.dto.OrganizationInfo;
import com.mohra.naurtki.dto.UserInfo;
import com.mohra.naurtki.entity.Organization;
import com.mohra.naurtki.entity.User;

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
