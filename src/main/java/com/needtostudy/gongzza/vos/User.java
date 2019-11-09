package com.needtostudy.gongzza.vos;


import java.util.Date;
public class User {
    private String id;
    private String name;
    private String password;
    private String salt;
    private Date birthday;
    private Date signedInAt;
    private int schoolId;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
