package com.needtostudy.gongzza.hashTag;

import com.needtostudy.gongzza.daos.HashTagDao;
import com.needtostudy.gongzza.vos.HashTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashTagServiceImpl implements HashTagService {

    @Autowired
    private HashTagDao hashTagDao;

    public void createHashTag(HashTag hashTag) {
        hashTagDao.insertHashTag(hashTag);
    }

    public List<HashTag> selectHashTagListByPostId(int postId) {
        return hashTagDao.selectHashTagListByPostId(postId);
    }
}
