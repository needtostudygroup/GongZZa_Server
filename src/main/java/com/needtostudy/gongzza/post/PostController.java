package com.needtostudy.gongzza.post;

import com.needtostudy.gongzza.dtos.PostDto;
import com.needtostudy.gongzza.vos.HashTag;
import com.needtostudy.gongzza.vos.Participant;
import com.needtostudy.gongzza.vos.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("")
    public PostDto insertPost(@RequestBody PostDto postDto) {
        return postService.insertPost(postDto);
    }

    @GetMapping("{id}")
    public PostDto selectPostDtoById(@PathVariable int id) {
        return postService.selectPostDtoById(id);
    }

    @GetMapping("schools/{schoolId}/recent")
    public List<PostDto> selectRecentPostDtoList(@PathVariable int schoolId,
                                                 @RequestParam String userId,
                                                 @RequestParam int limit) {
        return postService.selectRecentPostDtoList(userId, limit, schoolId);
    }

    @PutMapping("{id}")
    public boolean updatePost(@PathVariable int id, @RequestBody Post post) {
        post.setId(id);
        postService.updatePost(post);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return true;
    }

}
