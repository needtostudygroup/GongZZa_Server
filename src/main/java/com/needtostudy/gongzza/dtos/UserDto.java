package com.needtostudy.gongzza.dtos;

import java.util.Date;

public class UserDto {

    private String id;
    private String name;
    private String password;
    private Date birthday;
    private Date signedInAt;
    private int schoolId;

    public UserDto() {
    }

    public UserDto(String id, String name, String password, Date birthday, int schoolId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.schoolId = schoolId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getSignedInAt() {
        return signedInAt;
    }

    public void setSignedInAt(Date signedInAt) {
        this.signedInAt = signedInAt;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
}
