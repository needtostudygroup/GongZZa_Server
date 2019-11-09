package com.needtostudy.gongzza.token;

import com.needtostudy.gongzza.vos.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("")
    public ResponseEntity<Integer> registerToken(@RequestBody Token token) {
        tokenService.registerToken(token);
        return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }
}
