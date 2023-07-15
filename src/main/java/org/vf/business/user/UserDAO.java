package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.vf.business.mappers.UserMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
