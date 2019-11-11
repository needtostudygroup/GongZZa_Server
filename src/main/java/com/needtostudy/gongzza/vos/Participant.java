package com.needtostudy.gongzza.vos;

import com.needtostudy.gongzza.dtos.UserDto;

public class Participant extends UserDto {

    private int postId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
