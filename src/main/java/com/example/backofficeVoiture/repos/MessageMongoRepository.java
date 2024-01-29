package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Message;
import com.example.backofficeVoiture.domain.MessageMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MessageMongoRepository extends MongoRepository<MessageMongo, String> {

    List<MessageMongo> findMessageMongoByIdReceiver(String idUser);
    List<MessageMongo> findMessageMongoByIdSender(String idUser);
    List<MessageMongo> findMessageMongoByIdReceiverAndDateReceptionIsNull(String idReceveur);
    List<MessageMongo> findMessageMongoByIdReceiverAndIdSender(String idReceiver, String idSender);

}
