package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements UserDetailsService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder encoder;

    public User registerUser(String account, String password) {
        String encodedPassword = encoder.encode(password);
        User user = new User(0, account, encodedPassword);

        return userDAO.registerUser(user, account, encodedPassword);
    }
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        return this.userDAO.loadUserByAccount(account);
    }
}
