package com.needtostudy.gongzza.user;

import com.needtostudy.gongzza.dtos.UserDto;

import java.util.Date;

public interface UserService {

    UserDto signUp(UserDto user) throws Exception;

    UserDto getUserById(String id) throws Exception;

    UserDto getUserByIdPw(String id, String password) throws Exception;

    String findId(String name, Date birthday);

    int authenticateFindPassword(String id, String name, Date birthday);

    void setNewPassword(String id, String password) throws Exception;
}
