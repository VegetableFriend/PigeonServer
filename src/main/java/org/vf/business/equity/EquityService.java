package org.vf.business.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquityService {
    @Autowired
    EquityDAO equityDAO;

    void purchaseEquity(int type) {
        int remainCount = this.equityDAO.equityRemainCount(type);

        if (type > 0) {
            this.equityDAO.decreaseEquityCount(type);
            this.equityDAO.updateUserEquitiesStatus(0, type);
        }
    }
}
