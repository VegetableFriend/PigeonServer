package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void registerUser(User user, String account, String password) {
        userDAO.registerUser(user, account, password);
    }

    @Override
    public User login(String account, String password) {
        return this.userDAO.login(account, password);
    }
}
