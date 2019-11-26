package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.dtos.PostChatDto;
import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface ChatLogService {

    List<ChatLog> selectChatLogListAfterDatetime(int postId, Date datetime);

    List<PostChatDto> selectPostChatListByUserAfterDatetime(String userId, Date datetime);

    ChatLog insertChatLog(ChatLog chatLog) throws Exception;
}
