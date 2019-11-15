package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatLogService {

    List<ChatLog> selectChatLogList(int postId, int offset, int limit);

    ChatLog insertChatLog(ChatLog chatLog);
}
