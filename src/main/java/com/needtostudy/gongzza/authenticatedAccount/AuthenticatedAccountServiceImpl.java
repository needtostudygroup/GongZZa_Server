package com.needtostudy.gongzza.authenticatedAccount;

import com.needtostudy.gongzza.daos.AuthenticatedAccountDao;
import com.needtostudy.gongzza.daos.UserDao;
import com.needtostudy.gongzza.dtos.UserDto;
import com.needtostudy.gongzza.vos.AuthenticatedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedAccountServiceImpl implements AuthenticatedAccountService {

    @Autowired
    private AuthenticatedAccountDao authedAccountDao;

    @Autowired
    private UserDao userDao;

    public AuthenticatedAccount insertAuthedAccount(AuthenticatedAccount authedAccount) throws Exception {
        UserDto user = userDao.selectUserById(authedAccount.getUserId());
        if (user != null)
            throw new Exception();

        user = userDao.selectUserByEmail(authedAccount.getEmail());
        if (user != null)
            throw new Exception();

        authedAccountDao.insertAuthenticatedAccount(authedAccount);
        return authedAccountDao.selectAuthenticatedAccount(authedAccount);
    }

    public AuthenticatedAccount selectAuthedAccount(AuthenticatedAccount authedAccount) {
        return authedAccountDao.selectAuthenticatedAccount(authedAccount);
    }

    public void deleteAuthedAccount(AuthenticatedAccount authedAccount) {
        authedAccountDao.deleteAuthenticatedAccount(authedAccount);
    }
}
