package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Message2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Message2Repository extends JpaRepository<Message2, Integer> {
    java.util.List<Message2> findMessage2ByIdDiscussion(Integer idDiscussion);
    java.util.List<Message2> findMessage2ByIdDiscussionAndIdSenderAndIdReceiver(String idDiscussion,
                                                                                String idSendr,
                                                                                String idReceiver);

    @Query(value = "select * from (select * from message2 where id_discussion=:idd and id_sender=:ids and id_receiver=:idr" +
            " union select * from message2 where id_discussion=:idd and id_sender=:idr and id_receiver=:ids) order by date_envoie", nativeQuery = true)
    java.util.List<Message2> findMessage(String idd, String ids, String idr);
}
