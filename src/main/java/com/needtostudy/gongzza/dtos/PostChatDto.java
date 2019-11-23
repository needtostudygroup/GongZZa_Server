package com.needtostudy.gongzza.dtos;

import com.needtostudy.gongzza.vos.ChatLog;

import java.util.List;

public class PostChatDto extends PostDto {

    private List<ChatLog> chatLogList;

    public List<ChatLog> getChatLogList() {
        return chatLogList;
    }

    public void setChatLogList(List<ChatLog> chatLogList) {
        this.chatLogList = chatLogList;
    }
}
