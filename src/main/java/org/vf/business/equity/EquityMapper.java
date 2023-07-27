package org.vf.business.equity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EquityMapper {
    @Select("select equity_remain_count from equities where equity_type = #{type}")
    int equityRemainCount(@Param("type") int type);

    @Update("update equities set equity_remain_count = equity_remain_count - 1 where equity_type = #{type}")
    void decreaseEquityCount(int type);
}
