package com.needtostudy.gongzza.authMail;

import com.needtostudy.gongzza.vos.AuthMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authMails")
public class AuthMailController {

    @Autowired
    private AuthMailService authMailService;

    @PostMapping("users/{userId}/email/{email}")
    public AuthMail createAuthMail(@PathVariable String userId, @PathVariable String email) throws Exception {
        return authMailService.createAuthMail(userId, email);
    }

    @GetMapping("users/{userId}/email/{email}/code/{code}")
    public String authMail(@PathVariable String userId, @PathVariable String email,
                                         @PathVariable String code) {
        if (authMailService.authMail(userId, email, code) != null)
            return "Success";
        return "Failure";
    }

    @DeleteMapping("users/{userId}/email/{email}")
    public ResponseEntity<String> deleteAuthMail(@PathVariable String userId, @PathVariable String email) {
        authMailService.deleteAuthMail(userId, email);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
