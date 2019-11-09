package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.vos.ChatLog;
import com.needtostudy.gongzza.vos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chats")
public class ChatLogController {

    @Autowired
    private ChatLogService chatService;

    @GetMapping("")
    public List<ChatLog> selectChatLogList(@RequestParam int postId,
                                           @RequestParam int offset,
                                           @RequestParam int limit) {
        return chatService.selectChatLogList(postId, offset, limit);
    }

    @GetMapping("")
    public ChatLog insertChatLog(@RequestBody ChatLog chatLog) {
        return chatService.insertChatLog(chatLog);
    }
}
