package com.needtostudy.gongzza.vos;

import com.needtostudy.gongzza.dtos.UserDto;

public class Participant {

    private int postId;
    private UserDto user;

    public Participant() {
    }

    public Participant(String userId, int postId) {
        user = new UserDto(userId);
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}