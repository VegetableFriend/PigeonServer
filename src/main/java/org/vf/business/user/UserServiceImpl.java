package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public User registerUser(String account, String password) {
        String encodedPassword = encoder.encode(password);
        User user = new User(0, account, encodedPassword);

        return userDAO.registerUser(user, account, encodedPassword);
    }
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        return this.userDAO.loadUserByAccount(account);
    }
}
