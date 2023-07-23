package org.vf.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    User registerUser(@RequestPart("account") String account,
                      @RequestPart("password") String password) {
        User user = this.userService.registerUser(account, password);

        return user;
    }
}
