package com.needtostudy.gongzza.hashTag;

import com.needtostudy.gongzza.vos.HashTag;

import java.util.List;

public interface HashTagService {

    void createHashTag(HashTag hashTag);

    List<HashTag> selectHashTagListByPostId(int postId);
}
