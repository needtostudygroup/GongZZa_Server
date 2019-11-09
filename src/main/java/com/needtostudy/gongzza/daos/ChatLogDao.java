package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.ChatLog;
import com.needtostudy.gongzza.vos.School;
import com.needtostudy.gongzza.vos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLogDao {

    List<ChatLog> selectChatLogList(
            @Param("postId") int postId,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    ChatLog selectChatLog(int id);

    void insertChatLog(ChatLog chatLog);
}
