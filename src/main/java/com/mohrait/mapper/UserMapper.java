package com.mohrait.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohrait.dto.UserInfo;
import com.mohrait.entity.User;

/*
 * Created by Suresh Stalin on 17 / Oct / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface UserMapper {

    UserMapper INSTANCE =  Mappers.getMapper(UserMapper.class);
    User userInfoToUser(UserInfo userInfo);
    @InheritInverseConfiguration
    UserInfo userToUserInfo(User user);

}
