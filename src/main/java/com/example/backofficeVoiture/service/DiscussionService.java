package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Discussion;
import com.example.backofficeVoiture.domain.Message2;
import com.example.backofficeVoiture.domain.Utilisateur;
import com.example.backofficeVoiture.model.Message2DTO;
import com.example.backofficeVoiture.repos.DiscussionRepository;
import com.example.backofficeVoiture.repos.Message2Repository;
import com.example.backofficeVoiture.repos.UtilisateurRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class DiscussionService {
    @Autowired
    Message2Repository message2Repository;
    @Autowired
    DiscussionRepository discussionRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public ApiResponse getDiscussion(String idUser, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            java.util.List<Discussion> discussionList = discussionRepository.findDiscussionByIdReceiver(idUser);
            for(Discussion d : discussionList){
                Utilisateur user = utilisateurRepository.findUtilisateurByIdUtilisateur(d.getIdSender());
                d.setMessage2List(message2Repository.findMessage2ByIdDiscussion(d.getIdDiscussion()));
                d.setNombreMessage();
                d.setNomSender(user.getNom());
            }
            apiResponse.addData("discussion", discussionList);
        }catch (Exception e){
            apiResponse.setError(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse sendMessage(Message2DTO message2DTO) {

        ApiResponse apiResponse = new ApiResponse();
        try{
            Discussion discussion = mapEntity(message2DTO);
            discussionRepository.save(discussion);
            Message2 message2 = mapEntity(message2DTO, discussion.getIdDiscussion());
            message2Repository.save(message2);
        }catch (Exception e){
            e.printStackTrace();
            try{
                Discussion discussion1 = discussionRepository.findDiscussionByIdSender(message2DTO.getIdSender());
                Message2 message2 = mapEntity(message2DTO, discussion1.getIdDiscussion());
                message2.setDateEnvoie(Timestamp.valueOf(LocalDateTime.now()));
                message2Repository.save(message2);
            }catch (Exception e2){
                e2.printStackTrace();
                apiResponse.setError(e2.getMessage());
            }
        }
        return apiResponse;
    }

    Discussion mapEntity(Message2DTO message2DTO){
        Discussion discussion = new Discussion();
        discussion.setDateDiscussion(Timestamp.valueOf(LocalDateTime.now()));
        discussion.setIdAnnonce(message2DTO.getIdAnnonce());
        discussion.setIdSender(message2DTO.getIdSender());
        discussion.setIdReceiver(message2DTO.getIdReceiver());
        return discussion;
    }

    Message2 mapEntity(Message2DTO message2DTO, Integer idDiscussion){
        Message2 message2 = new Message2();
        message2.setMessage(message2DTO.getMessage());
        message2.setIdDiscussion(idDiscussion);
        message2.setIdReceiver(message2.getIdReceiver());
        message2.setIdSender(message2.getIdSender());
        return message2;
    }

    public ApiResponse getDiscussion(String idUser, String idSender, String idDiscussion, String token) {
        ApiResponse apiResponse = new ApiResponse();
        try{
            java.util.List<Message2> message1 = message2Repository.findMessage(
                    idDiscussion, idSender, idUser);
            apiResponse.addData("messages", message1);
        }catch (Exception e) {
            apiResponse.setError(e.getMessage());
        }
        return apiResponse;
    }
}
