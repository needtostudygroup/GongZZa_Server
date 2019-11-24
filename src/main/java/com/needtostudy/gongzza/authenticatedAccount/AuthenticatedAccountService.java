package com.needtostudy.gongzza.authenticatedAccount;

import com.needtostudy.gongzza.vos.AuthenticatedAccount;

public interface AuthenticatedAccountService {

    AuthenticatedAccount insertAuthedAccount(AuthenticatedAccount authedAccount) throws Exception;

    AuthenticatedAccount selectAuthedAccount(AuthenticatedAccount authedAccount);

    void deleteAuthedAccount(AuthenticatedAccount authedAccount);
}
