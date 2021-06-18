package com.mohra.naurtki.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mohra.naurtki.dto.CategoryInfo;
import com.mohra.naurtki.entity.Category;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@Mapper(implementationPackage = "mapper.impl")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryInfoToCategory(CategoryInfo categoryInfo);

    @InheritInverseConfiguration
    CategoryInfo categoryToCategoryInfo(Category category);

}
