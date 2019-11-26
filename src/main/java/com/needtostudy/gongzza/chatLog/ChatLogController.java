package com.needtostudy.gongzza.chatLog;

import com.needtostudy.gongzza.dtos.PostChatDto;
import com.needtostudy.gongzza.push.PushService;
import com.needtostudy.gongzza.vos.ChatLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("chats")
public class ChatLogController {

    @Autowired
    private ChatLogService chatLogService;

    @GetMapping("posts/{postId}")
    public List<ChatLog> selectChatLogListAfterDatetime(@PathVariable int postId,
                                                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssSSS") Date datetime) {
        return chatLogService.selectChatLogListAfterDatetime(postId, datetime);
    }

    @GetMapping("users")
    public List<PostChatDto> selectPostChatListByUserAfterDatetime(
            @RequestParam String userId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssSSS") Date datetime) {
        return chatLogService.selectPostChatListByUserAfterDatetime(userId, datetime);
    }

    @PostMapping("")
    public ChatLog insertChatLog(@RequestBody ChatLog chatLog) throws Exception {
        return chatLogService.insertChatLog(chatLog);
    }
}
