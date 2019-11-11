package com.needtostudy.gongzza.vos;

import com.needtostudy.gongzza.dtos.UserDto;

public class User extends UserDto {

    private String salt;

    public User() {
    }

    public User(UserDto userDto, String salt) {
        super(userDto.getId(), userDto.getName(), userDto.getPassword(), userDto.getBirthday(), userDto.getSchoolId());
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
