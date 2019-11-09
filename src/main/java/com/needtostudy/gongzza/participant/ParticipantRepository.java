package com.needtostudy.gongzza.participant;

import com.needtostudy.gongzza.vos.Participant;

import java.util.List;

public interface ParticipantRepository {

    Participant insertParticipant(Participant participant);

    void deleteParticipant(String id, int postId);

    List<Participant> selectParticipantListByPostId(int postId);
}
