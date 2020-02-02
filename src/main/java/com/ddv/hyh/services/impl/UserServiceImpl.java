package com.ddv.hyh.services.impl;

import com.ddv.hyh.common.ServiceResponse;
import com.ddv.hyh.dao.UserMapper;
import com.ddv.hyh.pojo.User;
import com.ddv.hyh.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public ServiceResponse<User> signIn(String username, String password) {
        // 检查账号是否存在
        int result = userMapper.checkUsername(username);
        if(result == 0) {
            return ServiceResponse.createByErrorMessage("账号不存在");
        }
        // 检查密码是否正确
        User user = userMapper.checkSignIn(username, password);
        if(user == null) {
            return ServiceResponse.createByErrorMessage("密码错误");
        }
        return ServiceResponse.createBySuccess("登录成功", user);
    }
}
