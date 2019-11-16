package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.AuthedAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthedAccountDao {

    void insertAuthedAccount(AuthedAccount authedAccount);

    AuthedAccount selectAuthedAccount(AuthedAccount authedAccount);

    void deleteAuthedAccount(AuthedAccount authedAccount);
}
