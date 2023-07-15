package org.vf.business.user;

public interface UserService {
    void registerUser(User user, String account, String password);

    User login(String account, String password);
}
