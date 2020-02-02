package com.ddv.hyh.services;

import com.ddv.hyh.common.ServiceResponse;
import com.ddv.hyh.pojo.User;

public interface IUserService {
    ServiceResponse<User> signIn(String username, String password);
}
