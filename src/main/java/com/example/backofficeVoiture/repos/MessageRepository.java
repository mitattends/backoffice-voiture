package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "select * from "+
            "((select * from message where id_sender = :idSender" +
            " and id_receiver = :idUser and id_annonce = :idAnnonce) union " +
            "(select * from message where id_sender = :idUser and id_receiver = :idSender and " +
            "id_annonce = :idAnnonce))" +
            " order by date_envoie", nativeQuery = true)
    List<Message> findMessageBetweenTwo(String idUser, String idSender, String idAnnonce);
    List<Message> findMessageByIdReceiverOrderByDateReceptionDesc(String idUser); // message nalefa
    List<Message> findMessageByIdSender(String idUser); // message voaray
    List<Message> findMessageByIdReceiverAndDateReceptionIsNull(String idReceveur);
    List<Message> findMEssageByIdReceiverAndIdSender(String idReceiver, String idSender);

    @Query(value = "with last_message_id as\n" +
            "    (select max (message.id_message) id_message, id_receiver from\n" +
            "        message where id_receiver = :idUser\n" +
            "                group by id_annonce, id_sender, id_receiver\n" +
            "    )\n" +
            "    select\n" +
            "        message.id_message, id_sender, message.id_receiver, message, date_envoie, date_reception, date_vue, id_annonce\n" +
            "    from message join last_message_id\n" +
            "        on message.id_receiver = last_message_id.id_receiver\n" +
            "        and message.id_message = last_message_id.id_message", nativeQuery = true)
    List<Message> myMessage(@Param("idUser") String idUser);
}
