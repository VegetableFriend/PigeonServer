package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    @Autowired
    UserMapper userMapper;

    public User registerUser(User user,String account, String password) {
        userMapper.registerUser(user, account, password);

        return user;
    }

    public User login(String account, String password) {
        return userMapper.getUserByAccount(account);
    }

    public User loadUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
