package com.needtostudy.gongzza.post;

import com.needtostudy.gongzza.dtos.PostDto;
import com.needtostudy.gongzza.vos.Post;

import java.util.List;

public interface PostService {

    PostDto insertPost(PostDto post);

    PostDto selectPostDtoById(int id);

    List<PostDto> selectRecentPostDtoList(String userId, int limit, int schoolId, String searchKeyword, String[] hashTagList);

    List<PostDto> selectUserEnrolledPost(String userId);

    void updatePost(Post post);

    void deletePost(int id);
}
