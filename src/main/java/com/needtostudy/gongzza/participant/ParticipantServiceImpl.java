package com.needtostudy.gongzza.participant;

import com.needtostudy.gongzza.daos.ParticipantDao;
import com.needtostudy.gongzza.vos.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantDao participantDao;

    @Transactional
    public Participant insertParticipant(Participant participant) {
        participantDao.insertParticipant(participant);
        return participantDao.selectParticipantById(participant.getId(), participant.getPostId());
    }

    public void deleteParticipant(String id, int postId) {
        participantDao.deleteParticipant(id, postId);
    }

    public List<Participant> selectParticipantListByPostId(int postId) {
        return participantDao.selectParticipantListByPostId(postId);
    }
}
