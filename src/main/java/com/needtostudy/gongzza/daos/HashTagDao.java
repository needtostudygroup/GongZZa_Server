package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.vos.HashTag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashTagDao {

    void createHashTag(HashTag hashTag);

    List<HashTag> selectHashTagListByPostId(int postId);
}
