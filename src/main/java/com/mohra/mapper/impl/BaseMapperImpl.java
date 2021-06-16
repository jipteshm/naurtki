package com.mohra.mapper.impl;

import javax.annotation.Generated;

import com.mohra.dto.BaseInfo;
import com.mohra.entity.BaseObject;
import com.mohra.mapper.BaseMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T09:21:21+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class BaseMapperImpl implements BaseMapper {

    @Override
    public BaseObject baseInfoToBaseObject(BaseInfo baseInfo) {
        if ( baseInfo == null ) {
            return null;
        }

        BaseObject baseObject = new BaseObject();

        baseObject.setId( baseInfo.getId() );

        return baseObject;
    }

    @Override
    public BaseInfo baseObjectToBaseInfo(BaseObject baseObject) {
        if ( baseObject == null ) {
            return null;
        }

        BaseInfo baseInfo = new BaseInfo();

        baseInfo.setId( baseObject.getId() );

        return baseInfo;
    }
}
