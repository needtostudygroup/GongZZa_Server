package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
    public String findId(@RequestParam String name, @RequestParam Date birthday) throws Exception {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTime(birthday);
        c.add(Calendar.HOUR, -9);
        birthday = c.getTime();
        return userService.findId(name, birthday);
    }

    @GetMapping("find/password")
    public int authenticateFindPassword(@RequestParam String id, @RequestParam String name, @RequestParam Date birthday) throws Exception {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTime(birthday);
        c.add(Calendar.HOUR, -9);
        birthday = c.getTime();
        return userService.authenticateFindPassword(id, name, birthday);
    }

    @PutMapping("find/password")
    public int findPassword(@RequestParam String id, @RequestParam String password, @RequestParam int authorityCode) throws Exception {
        if (authorityCode == 200)
            userService.setNewPassword(id, password);
        return authorityCode;
    }
}
