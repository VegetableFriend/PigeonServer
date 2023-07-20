package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vf.business.mappers.user.UserMapper;

@Component
public class UserDAO {
    @Autowired
    UserMapper userMapper;

    public void registerUser(User user,String account, String password) {
        userMapper.registerUser(user, account, password);
    }

    public User login(String account, String password) {
        return userMapper.getUserByAccount(account);
    }
}
