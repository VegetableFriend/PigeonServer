package org.vf.business.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EquityService {
    @Autowired
    EquityDAO equityDAO;
    @Transactional(rollbackFor = Exception.class)
    void purchaseEquity(int type) {
        int remainCount = this.equityDAO.equityRemainCount(type);

//        if (remainCount > 0) {
            this.equityDAO.decreaseEquityCount(type);
            this.equityDAO.updateUserEquitiesStatus(0, type);
//        }
    }
}
