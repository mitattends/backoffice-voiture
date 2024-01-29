package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Message;
import com.example.backofficeVoiture.domain.MessageMongo;
import com.example.backofficeVoiture.model.MessageDTO;
import com.example.backofficeVoiture.service.MessageService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @PostMapping
    public ApiResponse send(@RequestBody MessageDTO messageDTO, @RequestHeader("Authorization") String token){
        System.out.println("sendif");
        return messageService.saveMessage(messageDTO, token);
    }
    @GetMapping("/{idUser}")
    public ApiResponse getMessage(@PathVariable String idUser, @RequestHeader("Authorization") String token){
        return messageService.getMessage(idUser, token);
    }

    @GetMapping("/{idUser}/notread")
    public ApiResponse getNotReadMessage(@PathVariable String idUser, @RequestHeader("Authorization") String token){
        return messageService.getNotReadMessage(idUser, token);
    }

    @GetMapping
    public List<Message> get(){
        return messageService.messageMongos();
    }
}
