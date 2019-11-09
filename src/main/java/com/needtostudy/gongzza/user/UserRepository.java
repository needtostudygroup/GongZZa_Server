package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.vos.User;

public interface UserRepository {

    User signUp(User user) throws Exception;

    User getUserByIdPw(String id, String password) throws Exception;
}
