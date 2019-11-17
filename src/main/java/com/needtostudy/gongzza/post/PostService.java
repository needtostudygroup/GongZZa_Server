package com.needtostudy.gongzza.post;

import com.needtostudy.gongzza.dtos.PostDto;
import com.needtostudy.gongzza.vos.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostService {

    PostDto insertPost(PostDto post);

    PostDto selectPostDtoById(int id);

    List<PostDto> selectRecentPostDtoList(String userId, int limit, int schoolId);

    void updatePost(Post post);

    void deletePost(int id);
}
