package com.needtostudy.gongzza.authMail;

import com.needtostudy.gongzza.vos.AuthMail;
import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authMails")
public class AuthMailController {

    @Autowired
    private AuthMailService authMailService;

    @PostMapping("")
    public AuthMail createAuthMail(@RequestParam String userId, @RequestParam String email) throws Exception {
        return authMailService.createAuthMail(userId, email);
    }

    @GetMapping("code/{code}")
    public boolean authMail(@RequestParam String userId, @RequestParam String email,
                                         @PathVariable String code) {
        if (authMailService.authMail(userId, email, code) != null)
            return true;
        return false;
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAuthMail(@RequestParam String userId, @RequestParam String email) {
        authMailService.deleteAuthMail(userId, email);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
