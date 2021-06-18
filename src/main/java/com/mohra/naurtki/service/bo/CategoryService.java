package com.mohra.naurtki.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mohra.naurtki.common.CodeGenerator;
import com.mohra.naurtki.common.staticdata.CodeType;
import com.mohra.naurtki.common.staticdata.Constants;
import com.mohra.naurtki.dto.CategoryInfo;
import com.mohra.naurtki.entity.Category;
import com.mohra.naurtki.mapper.CategoryMapper;
import com.mohra.naurtki.messages.ResponseMessage;
import com.mohra.naurtki.repository.CategoryRepository;
import com.mohra.naurtki.service.BaseService;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@Service
public class CategoryService extends BaseService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CodeGenerator codeGenerator;

    public ResponseMessage save(CategoryInfo categoryInfo) {
        Category category = CategoryMapper.INSTANCE.categoryInfoToCategory(categoryInfo);
        if(StringUtils.isEmpty(category.getCategoryCode())) {
            String categoryCode = codeGenerator.newCode(CodeType.CATEGORY_CODE);
            category.setCategoryCode(categoryCode);
        }
        Category newCategory = categoryRepository.save(category);
        CategoryInfo categoryInfoResponse = CategoryMapper.INSTANCE.categoryToCategoryInfo(newCategory);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(categoryInfoResponse, "Category Saved" +
                " Successfully", Constants.INFO_TYPE);
        return responseMessage;
    }

    @Override
    public ResponseMessage findResourceById(String id) throws Exception {
        Category category = categoryRepository.findById(Long.parseLong(id)).orElse(null);
        CategoryInfo categoryInfoResponse = CategoryMapper.INSTANCE.categoryToCategoryInfo(category);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(categoryInfoResponse, Constants.SUCCESS_STATUS, Constants.INFO_TYPE);
        return responseMessage;
    }

    @Override
    public ResponseMessage findAll() throws Exception {
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category:categories) {
            CategoryInfo categoryInfo = CategoryMapper.INSTANCE.categoryToCategoryInfo(category);
            categoryInfos.add(categoryInfo);
        }
        ResponseMessage responseMessage = ResponseMessage.withResponseData(categoryInfos,Constants.SUCCESS_STATUS,Constants.INFO_TYPE);
        return responseMessage;
    }
}
