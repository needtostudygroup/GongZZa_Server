package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.dtos.PostChatDto;
import com.needtostudy.gongzza.vos.ChatLog;
import com.needtostudy.gongzza.vos.School;
import com.needtostudy.gongzza.vos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChatLogDao {

    List<ChatLog> selectChatLogListAfterDatetime(
            @Param("postId") int postId,
            @Param("datetime") Date datetime
    );

    List<PostChatDto> selectPostChatListByUserAfterDatetime(
            @Param("userId") String userId,
            @Param("datetime") Date datetime);

    ChatLog selectChatLog(int id);

    void insertChatLog(ChatLog chatLog);
}
