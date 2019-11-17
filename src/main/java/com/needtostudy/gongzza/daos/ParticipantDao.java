package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.Participant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantDao {

    void insertParticipant(Participant participant);

    void deleteParticipant(@Param("userId") String userId,
                           @Param("postId") int postId);

    List<Participant> selectParticipantListByPostId(int postId);

    Participant selectParticipantById(@Param("userId") String userId,
                                      @Param("postId") int postId);
}
