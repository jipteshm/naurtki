package com.mohra.naurtki.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mohra.naurtki.entity.User;
import com.mohra.naurtki.messages.ResponseMessage;
import com.mohra.naurtki.repository.UserRepository;
import com.mohra.naurtki.service.BaseService;

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
