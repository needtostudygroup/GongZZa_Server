package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.vos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public User signUp(@RequestBody User user) throws Exception {
        return userService.signUp(user);
    }

    @GetMapping("")
    public User login(@RequestParam String id, @RequestParam String password, @RequestParam int serviceId) throws Exception {
        return userService.getUserByIdPw(id, password, serviceId);
    }
}
