package org.vf.business.mappers.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.vf.business.user.User;

public interface UserMapper {
    @Select("select uid, account from users where account = #{account}")
    User getUserByAccount(@Param("account") String account);

    @Options(useGeneratedKeys = true, keyProperty = "User.uid", keyColumn = "uid")
    @Insert("insert into users(account, password) values(#{account}, #{password})")
    void registerUser(@Param("User") User user,
                      @Param("account") String account,
                      @Param("password")String password);
}
