package org.vf.business.equity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equity")
public class EquityController {
    @Autowired
    EquityService equityService;

    @RequestMapping("/purchase")
    void purchaseEquity(@RequestParam("type") int type) {
        this.equityService.purchaseEquity(type);
    }
}
