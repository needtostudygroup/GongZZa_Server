package com.needtostudy.gongzza.authedAccount;

import com.needtostudy.gongzza.daos.AuthedAccountDao;
import com.needtostudy.gongzza.daos.UserDao;
import com.needtostudy.gongzza.dtos.UserDto;
import com.needtostudy.gongzza.vos.AuthedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthedAccountServiceImpl implements AuthedAccountService {

    @Autowired
    private AuthedAccountDao authedAccountDao;

    @Autowired
    private UserDao userDao;

    public AuthedAccount insertAuthedAccount(AuthedAccount authedAccount) throws Exception {
        UserDto user = userDao.selectUserById(authedAccount.getUserId());
        if (user != null)
            throw new Exception();

        user = userDao.selectUserByEmail(authedAccount.getEmail());
        if (user != null)
            throw new Exception();

        authedAccountDao.insertAuthedAccount(authedAccount);
        return authedAccountDao.selectAuthedAccount(authedAccount);
    }

    public AuthedAccount selectAuthedAccount(AuthedAccount authedAccount) {
        return authedAccountDao.selectAuthedAccount(authedAccount);
    }

    public void deleteAuthedAccount(AuthedAccount authedAccount) {
        authedAccountDao.deleteAuthedAccount(authedAccount);
    }
}
