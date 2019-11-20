package com.needtostudy.gongzza.tokens;

import com.needtostudy.gongzza.vos.Token;

import java.util.List;

public interface TokenService {

    Token insertToken(Token token);

    List<Token> selectTokenByUserId(String userId);
}
