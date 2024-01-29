package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Message;
import com.example.backofficeVoiture.domain.Utilisateur;
import com.example.backofficeVoiture.model.MessageDTO;
import com.example.backofficeVoiture.repos.MessageRepository;
import com.example.backofficeVoiture.repos.UtilisateurRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public ApiResponse getNotReadMessage(String idUser, String token){
        ApiResponse apiResponse = new ApiResponse();
        try {
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            List<Message> messages = messageRepository.findMessageByIdReceiverAndDateReceptionIsNull(idUser);
            List<MessageDTO> messageDTOS = mapListMessage(messages);
            apiResponse.addData("notification", messageDTOS);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse getMessage(String idUser, String token){
        System.out.println("LASA");
        ApiResponse apiResponse = new ApiResponse();
        try{
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            List<Message> messageRecu =  messageRepository.findMessageByIdReceiver(utilisateur.getIdUtilisateur());
            List<Message> messageEnvoye = messageRepository.findMessageByIdSender(utilisateur.getIdUtilisateur());
            apiResponse.addData("recu", mapListMessage(messageRecu));
            apiResponse.addData("envoye", mapListMessage(messageEnvoye));
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse saveMessage(MessageDTO messageDTO, String token){
        ApiResponse apiResponse = new ApiResponse();
        try {
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            Message message = mapDTOtoEntity(messageDTO);
            message.setIdSender(utilisateur.getIdUtilisateur());
            messageRepository.save(message);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return new ApiResponse();
    }

    public List<MessageDTO> mapListMessage(List<Message> messages){
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message m : messages){
            MessageDTO messageDTO=mapDTOtoEntity(m);
            messageDTOS.add(messageDTO);
        }
        return messageDTOS;
    }
    public Message mapDTOtoEntity(MessageDTO messageDTO){
        Message message = new Message();
        message.setIdReceiver(messageDTO.getIdReceveur());
        message.setIdSender(messageDTO.getIdEnvoyeur());
        message.setMessage(messageDTO.getMessage());
        message.setDateEnvoie(messageDTO.getDateEnvoie());
        message.setDateVue(messageDTO.getDateVue());
        message.setDateReception(messageDTO.getDateReception());
        return message;
    }

    public MessageDTO mapDTOtoEntity(Message message){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setIdEnvoyeur(message.getIdReceiver());
        messageDTO.setIdEnvoyeur(message.getIdSender());
        messageDTO.setMessage(message.getMessage());
        messageDTO.setDateEnvoie(message.getDateEnvoie().toString());
       // messageDTO.setDateEnvoie(message.getDateEnvoie().toString());
        messageDTO.setNomEnvoyeur(utilisateurRepository.findUtilisateurByIdUtilisateur(message.getIdSender()).getNom());
        messageDTO.setNomReceveur(utilisateurRepository.findUtilisateurByIdUtilisateur(message.getIdReceiver()).getNom());
        return messageDTO;
    }
}
