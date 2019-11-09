package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.Participant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantDao {

    void insertParticipant(Participant participant);

    void deleteParticipant(String id, int postId);

    List<Participant> selectParticipantListByPostId(int postId);

    Participant selectParticipantById(String id, int postId);
}
