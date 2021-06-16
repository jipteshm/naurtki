package com.mohra.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mohra.entity.User;
import com.mohra.messages.ResponseMessage;
import com.mohra.repository.UserRepository;
import com.mohra.service.BaseService;

/*
 * Created by Suresh Stalin on 04 / Nov / 2020.
 */

@Service("userService")
class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    public ResponseMessage findResourceById(String id) throws Exception {

        User user = userRepository.findById(Long.parseLong(id)).orElse(null);
        ResponseMessage responseMessage = ResponseMessage.withResponseData(user, "", "");
        return responseMessage;

    }

    @Override
    public ResponseMessage findAll() throws Exception {
        return null;
    }
}
