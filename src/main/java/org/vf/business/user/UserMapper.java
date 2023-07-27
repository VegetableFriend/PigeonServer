package org.vf.business.user;

import org.apache.ibatis.annotations.*;
import org.vf.business.user.User;

@Mapper
public interface UserMapper {
    @Select("select uid, account, password from users where account = #{account}")
    User getUserByAccount(@Param("account") String account);

    @Options(useGeneratedKeys = true, keyProperty = "User.uid", keyColumn = "uid")
    @Insert("insert into users(account, password) values(#{account}, #{password})")
    void registerUser(@Param("User") User user,
                      @Param("account") String account,
                      @Param("password")String password);
}
