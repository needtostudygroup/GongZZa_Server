package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.vos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("services/{serviceId}")
    public User signUp(@RequestBody User user, @PathVariable int serviceId) throws Exception {
        user.setServiceId(serviceId);
        return userService.signUp(user);
    }

    @GetMapping("login")
    public User login(@RequestParam String id, @RequestParam String password, @RequestParam int serviceId) throws Exception {
        return userService.getUserByIdPw(id, password, serviceId);
    }
}
