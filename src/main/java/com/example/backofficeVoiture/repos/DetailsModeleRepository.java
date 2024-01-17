package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.DetailsModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsModeleRepository extends JpaRepository<DetailsModele, String> {
    @Query(value = "SELECT NEXTVAL('seq_details_modele')", nativeQuery = true)
    Long getNextSequenceValue();
}
