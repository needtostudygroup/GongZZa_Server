package com.needtostudy.gongzza.authedAccount;

import com.needtostudy.gongzza.vos.AuthedAccount;

public interface AuthedAccountService {

    AuthedAccount insertAuthedAccount(AuthedAccount authedAccount) throws Exception;

    AuthedAccount selectAuthedAccount(AuthedAccount authedAccount);

    void deleteAuthedAccount(AuthedAccount authedAccount);
}
