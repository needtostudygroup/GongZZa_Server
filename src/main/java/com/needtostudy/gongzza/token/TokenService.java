package com.needtostudy.gongzza.token;

import com.needtostudy.gongzza.daos.TokenDao;
import com.needtostudy.gongzza.vos.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements TokenRepository {

    @Autowired
    private TokenDao tokenDao;

    public void registerToken(Token token) {
        Token t = tokenDao.selectUserById(token.getId());
        if (t == null)
            tokenDao.createToken(token);
        else if (!t.getToken().equals(token.getToken())) {
            tokenDao.updateUser(token);
        }
    }
}
