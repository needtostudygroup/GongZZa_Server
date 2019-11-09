package com.needtostudy.gongzza.participant;

import com.needtostudy.gongzza.vos.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping("")
    public Participant insertParticipant(@RequestBody Participant participant) {
        return participantService.insertParticipant(participant);
    }

    @DeleteMapping("{id}/posts/{postId}")
    public void deleteParticipant(@PathVariable String id, @PathVariable int postId) {
        participantService.deleteParticipant(id, postId);
    }

    @GetMapping("posts/{postId}")
    public List<Participant> selectParticipantListByPostId(@PathVariable int postId) {
        return participantService.selectParticipantListByPostId(postId);
    }
}
