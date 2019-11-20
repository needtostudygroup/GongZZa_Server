package com.needtostudy.gongzza.tokens;

import com.needtostudy.gongzza.daos.TokenDao;
import com.needtostudy.gongzza.vos.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Transactional
    public Token insertToken(Token token) {
        tokenDao.insertToken(token);
        return tokenDao.selectToken(token.getUserId(), token.getToken());
    }

    public List<Token> selectTokenByUserId(String userId) {
        return tokenDao.selectTokenByUserId(userId);
    }
}
