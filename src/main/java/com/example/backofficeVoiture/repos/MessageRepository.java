package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findMessageByIdReceiver(String idUser); // message nalefa
    List<Message> findMessageByIdSender(String idUser); // message voaray
    List<Message> findMessageByIdReceiverAndDateReceptionIsNull(String idReceveur);
     List<Message> findMEssageByIdReceiverAndIdSender(String idReceiver, String idSender);
}
