package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.AuthenticatedAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticatedAccountDao {

    void insertAuthenticatedAccount(AuthenticatedAccount authedAccount);

    AuthenticatedAccount selectAuthenticatedAccount(AuthenticatedAccount authedAccount);

    AuthenticatedAccount selectAuthenticatedAccountById(String userId);

    AuthenticatedAccount selectAuthenticatedAccountByEmail(String email);

    void deleteAuthenticatedAccount(AuthenticatedAccount authedAccount);
}
