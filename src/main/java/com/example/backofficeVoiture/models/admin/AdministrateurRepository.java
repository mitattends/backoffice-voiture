package com.example.backofficeVoiture.models.admin;

import com.example.backofficeVoiture.domain.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, String> {
    @Query(value = "SELECT NEXTVAL('seq_administrateur')", nativeQuery = true)
    Long getNextSequenceValue();
    Administrateur findAdministrateurByEmailAndMotDePasse(String email, String motDePasse);
}
