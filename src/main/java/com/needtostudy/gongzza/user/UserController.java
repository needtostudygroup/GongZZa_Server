package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public UserDto signUp(@RequestBody UserDto user) throws Exception {
        return userService.signUp(user);
    }

    @GetMapping("")
    public UserDto getUser(@RequestParam String id) throws Exception {
        return userService.getUserById(id);
    }

    @GetMapping("login")
    public UserDto login(@RequestParam String id, @RequestParam String password) throws Exception {
        return userService.getUserByIdPw(id, password);
    }

    @GetMapping("find/id")
    public String findId(@RequestParam String name, @RequestParam String email) throws Exception {
        return userService.findId(name, email);
    }

    @GetMapping("find/password")
    public int authenticateFindPassword(@RequestParam String id, @RequestParam String email) throws Exception {
        return userService.authenticateFindPassword(id, email);
    }

    @PutMapping("find/password")
    public int findPassword(@RequestParam String id, @RequestParam String password, @RequestParam int authorityCode) throws Exception {
        if (authorityCode == 200)
            userService.setNewPassword(id, password);
        return authorityCode;
    }
}
