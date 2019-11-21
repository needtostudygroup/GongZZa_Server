package com.needtostudy.gongzza.daos;

import com.needtostudy.gongzza.dtos.PostDto;
import com.needtostudy.gongzza.vos.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {

    void insertPost(Post post);

    PostDto selectPostDtoById(int id);

    List<PostDto> selectUserEnrolledPost(String userId);

    List<PostDto> selectRecentPostDtoList(@Param("userId") String userId,
                                          @Param("limit") int limit,
                                          @Param("schoolId") int schoolId);

    void updatePost(Post post);

    void deletePost(int id);
}
