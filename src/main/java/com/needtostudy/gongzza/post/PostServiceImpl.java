package com.needtostudy.gongzza.post;

import com.needtostudy.gongzza.daos.HashTagDao;
import com.needtostudy.gongzza.daos.ParticipantDao;
import com.needtostudy.gongzza.daos.PostDao;
import com.needtostudy.gongzza.dtos.PostDto;
import com.needtostudy.gongzza.vos.HashTag;
import com.needtostudy.gongzza.vos.Participant;
import com.needtostudy.gongzza.vos.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private ParticipantDao participantDao;

    @Autowired
    private HashTagDao hashTagDao;

    public PostDto insertPost(PostDto postDto) {
        postDao.insertPost(postDto);
        Participant participant = new Participant(postDto.getUserId(), postDto.getId());
        participantDao.insertParticipant(participant);
        if (postDto.getHashTagList() != null) {
            for (HashTag hashTag : postDto.getHashTagList()) {
                hashTagDao.insertHashTag(new HashTag(0, postDto.getId(), hashTag.getTitle(), hashTag.getColor()));
            }
        }
        return postDao.selectPostDtoById(postDto.getId());
    }

    public PostDto selectPostDtoById(int id) {
        return postDao.selectPostDtoById(id);
    }

    public List<PostDto> selectRecentPostDtoList(String userId, int limit, int schoolId) {
        return postDao.selectRecentPostDtoList(userId, limit, schoolId);
    }

    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    public void deletePost(int id) {
        postDao.deletePost(id);
    }
}
