package org.vf.business.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquityDAO {
    @Autowired
    EquityMapper equityMapper;

    @Autowired
    UserEquitiesMapper userEquitiesMapper;

    int equityRemainCount(int type) {
        return this.equityMapper.equityRemainCount(type);
    }

    void decreaseEquityCount(int type) {
        this.equityMapper.decreaseEquityCount(type);
    }

    void updateUserEquitiesStatus(int uid,
                                  int equityID) {
        this.userEquitiesMapper.updateUserEquitiesStatus(uid, equityID);
    }
}
