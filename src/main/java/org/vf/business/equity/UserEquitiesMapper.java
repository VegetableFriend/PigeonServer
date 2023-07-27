package org.vf.business.equity;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserEquitiesMapper {
    @Insert("insert into user_equities(uid, equity_id) values(#{uid}, #{equity_id})")
    void updateUserEquitiesStatus(@Param("uid") int uid,
                                  @Param("equity_id") int equityID);
}
