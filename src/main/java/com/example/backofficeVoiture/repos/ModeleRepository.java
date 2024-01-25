package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, String> {
    @Query(value = "SELECT NEXTVAL('seq_modele')", nativeQuery = true)
    Long getNextSequenceValue();

    boolean existsByIdModeleIgnoreCase(String idModele);
}
