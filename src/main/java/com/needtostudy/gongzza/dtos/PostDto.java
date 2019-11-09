package com.needtostudy.gongzza.dtos;

import com.needtostudy.gongzza.vos.HashTag;
import com.needtostudy.gongzza.vos.Participant;
import com.needtostudy.gongzza.vos.Post;

import java.util.List;

public class PostDto extends Post {

    private List<Participant> participantList;
    private List<HashTag> hashTagList;

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public List<HashTag> getHashTagList() {
        return hashTagList;
    }

    public void setHashTagList(List<HashTag> hashTagList) {
        this.hashTagList = hashTagList;
    }
}
