package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.daos.ChatLogDao;
import com.needtostudy.gongzza.dtos.PostChatDto;
import com.needtostudy.gongzza.push.PushService;
import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ChatLogServiceImpl implements ChatLogService {

    @Autowired
    private ChatLogDao chatLogDao;

    @Autowired
    private PushService pushService;


    public List<ChatLog> selectChatLogListAfterDatetime(int postId, Date datetime) {
        return chatLogDao.selectChatLogListAfterDatetime(postId, datetime);
    }

    public List<PostChatDto> selectPostChatListByUserAfterDatetime(String userId, Date datetime) {
        return chatLogDao.selectPostChatListByUserAfterDatetime(userId, datetime);
    }

    @Transactional
    public ChatLog insertChatLog(ChatLog chatLog) throws Exception {
        chatLogDao.insertChatLog(chatLog);
        pushService.push(chatLog);
        return chatLogDao.selectChatLog(chatLog.getId());
    }
}
