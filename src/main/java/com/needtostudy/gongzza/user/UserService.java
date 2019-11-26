package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.dtos.UserDto;

public interface UserService {

    UserDto signUp(UserDto user) throws Exception;

    UserDto getUserById(String id) throws Exception;

    UserDto getUserByIdPw(String id, String password) throws Exception;

    String findId(String name, String email);

    int authenticateFindPassword(String id, String email);

    void setNewPassword(String id, String password) throws Exception;
}
