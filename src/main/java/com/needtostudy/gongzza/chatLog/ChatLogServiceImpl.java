package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.daos.ChatLogDao;
import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatLogServiceImpl implements ChatLogService {

    @Autowired
    private ChatLogDao chatLogDao;

    public List<ChatLog> selectChatLogList(int postId, int offset, int limit) {
        return chatLogDao.selectChatLogList(postId, offset, limit);
    }

    @Transactional
    public ChatLog insertChatLog(ChatLog chatLog) {
        chatLogDao.insertChatLog(chatLog);
        return chatLogDao.selectChatLog(chatLog.getId());
    }
}
