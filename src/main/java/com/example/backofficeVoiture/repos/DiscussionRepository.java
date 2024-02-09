package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer> {
    java.util.List<Discussion> findDiscussionByIdReceiver(String idReceiver);
    Discussion findDiscussionByIdSender(String idReceiver);
}
