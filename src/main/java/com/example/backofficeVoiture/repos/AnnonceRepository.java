package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    @Query(value = "SELECT NEXTVAL('seq_annonce')", nativeQuery = true)
    Long getNextSequenceValue();
}
