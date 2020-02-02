package com.ddv.hyh.dao;

import com.ddv.hyh.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    // 检查账号
    int checkUsername(String username);
    // 检查密码
    int checkPassword(int userId, String password);
    // 检查登录
    User checkSignIn(String username, String password);
}
