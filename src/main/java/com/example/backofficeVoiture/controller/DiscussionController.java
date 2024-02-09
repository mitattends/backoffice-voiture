package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.model.Message2DTO;
import com.example.backofficeVoiture.service.DiscussionService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {
    @Autowired
    DiscussionService discussionService;
    @GetMapping("/{idUser}")
    public ApiResponse getUserMessage(@PathVariable("idUser") String idUser, @RequestHeader("Authorization") String token){
        return discussionService.getDiscussion(idUser, token);
    }

    @GetMapping("/{idUser}/{idSender}/{idDiscussion}")
    public ApiResponse getUserMessageByIdSenderAndIdAnnonce(
            @PathVariable("idUser") String idUser,
            @PathVariable("idSender") String idSender,
            @PathVariable("idDiscussion") String idDiscussion,
            @RequestHeader("Authorization") String token){
        return discussionService.getDiscussion(idUser, idSender, idDiscussion, token);
    }

    @PostMapping
    public ApiResponse sendMessage(@RequestBody Message2DTO message2DTO){
        return discussionService.sendMessage(message2DTO);
    }
}
