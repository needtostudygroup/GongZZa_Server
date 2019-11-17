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

    @DeleteMapping("posts/{postId}")
    public boolean deleteParticipant(@PathVariable int postId, @RequestParam String id) {
        participantService.deleteParticipant(id, postId);
        return true;
    }

    @GetMapping("posts/{postId}")
    public List<Participant> selectParticipantListByPostId(@PathVariable int postId) {
        return participantService.selectParticipantListByPostId(postId);
    }
}
