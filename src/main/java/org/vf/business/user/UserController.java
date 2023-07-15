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
        User user = new User(0, account);
        this.userService.registerUser(user, account, password);

        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    User login(@RequestPart("account") String account,
               @RequestPart("password") String password) {
        return this.userService.login(account, password);
    }
}
