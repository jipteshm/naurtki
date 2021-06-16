package com.mohrait.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohrait.common.staticdata.Constants;
import com.mohrait.dto.UserRoleInfo;
import com.mohrait.entity.Role;
import com.mohrait.messages.ResponseMessage;
import com.mohrait.repository.RoleRepository;
import com.mohrait.service.BaseService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * Created by Suresh Stalin on 23 / Nov / 2020.
 */

@Service
public class RoleService extends BaseService {

    @Autowired
    private RoleRepository roleRepository;
    @PersistenceContext
    EntityManager em;

    @Override
    public ResponseMessage findResourceById(String id) throws Exception {
        Object[] objects = roleRepository.getSuperAdmin(Long.parseLong(id));
        UserRoleInfo userRoleInfo = null;
        if (objects.length > 0) {
            userRoleInfo = new UserRoleInfo();
            Object object[] = (Object[]) objects[0];
            userRoleInfo.setUserId(Long.parseLong(object[0].toString()));
            userRoleInfo.setRoleId(Long.parseLong(object[1].toString()));
        }
        return ResponseMessage.withResponseData(userRoleInfo, Constants.SUCCESS_STATUS, Constants.INFO_TYPE);
    }

    @Override
    public ResponseMessage findAll() throws Exception {
        return null;
    }

    public Role findByName(String roleName) {
       return roleRepository.findByName(roleName).orElse(null);
    }
}
