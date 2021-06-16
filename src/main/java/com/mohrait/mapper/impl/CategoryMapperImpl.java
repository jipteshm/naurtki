package com.mohrait.mapper.impl;

import javax.annotation.Generated;

import com.mohrait.dto.CategoryInfo;
import com.mohrait.entity.Category;
import com.mohrait.mapper.CategoryMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T09:21:20+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryInfoToCategory(CategoryInfo categoryInfo) {
        if ( categoryInfo == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryInfo.getId() );
        category.setCategoryCode( categoryInfo.getCategoryCode() );
        category.setName( categoryInfo.getName() );
        category.setDescription( categoryInfo.getDescription() );

        return category;
    }

    @Override
    public CategoryInfo categoryToCategoryInfo(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryInfo categoryInfo = new CategoryInfo();

        categoryInfo.setId( category.getId() );
        categoryInfo.setCategoryCode( category.getCategoryCode() );
        categoryInfo.setName( category.getName() );
        categoryInfo.setDescription( category.getDescription() );

        return categoryInfo;
    }
}
