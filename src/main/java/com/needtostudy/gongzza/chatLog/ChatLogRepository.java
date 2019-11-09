package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.vos.ChatLog;

import java.util.List;

public interface ChatLogRepository {

    List<ChatLog> selectChatLogList(int postId, int offset, int limit);

    ChatLog insertChatLog(ChatLog chatLog);
}
