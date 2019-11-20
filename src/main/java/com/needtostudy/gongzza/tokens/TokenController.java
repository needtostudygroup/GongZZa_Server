package com.needtostudy.gongzza.tokens;

import com.needtostudy.gongzza.vos.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public Token insertToken(@RequestBody Token token) {
        return tokenService.insertToken(token);
    }
}
