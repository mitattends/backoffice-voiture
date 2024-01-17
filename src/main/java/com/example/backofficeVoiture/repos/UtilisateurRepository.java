package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    @Query(value = "SELECT NEXTVAL('seq_utilisateur')", nativeQuery = true)
    Long getNextSequenceValue();

    Utilisateur findUtilisateurByIdUtilisateur(String id);

    Utilisateur findUtilisateurByMotDePasseAndEmail(String password, String email);
}
