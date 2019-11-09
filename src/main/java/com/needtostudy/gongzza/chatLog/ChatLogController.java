package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chats")
public class ChatLogController {

    @Autowired
    private ChatLogService chatLogService;

    @GetMapping("")
    public List<ChatLog> selectChatLogList(@RequestParam int postId,
                                           @RequestParam int offset,
                                           @RequestParam int limit) {
        return chatLogService.selectChatLogList(postId, offset, limit);
    }

    @PostMapping("")
    public ChatLog insertChatLog(@RequestBody ChatLog chatLog) {
        return chatLogService.insertChatLog(chatLog);
    }
}
