package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.AuthenticationResponseInfo;
import com.mohrait.entity.JwtToken;

/*
 * Created by Suresh Stalin on 10 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface JwtResponseMapper {

    JwtResponseMapper INSTANCE = Mappers.getMapper(JwtResponseMapper.class);

    JwtToken authResponseToJwt(AuthenticationResponseInfo authenticationResponseDTO);

    @InheritInverseConfiguration
    AuthenticationResponseInfo jwtToAuthResponse(JwtToken jwtToken);
}
