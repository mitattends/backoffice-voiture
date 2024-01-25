package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Annonce;
import com.example.backofficeVoiture.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, String> {
    @Query(value = "SELECT NEXTVAL('seq_annonce')", nativeQuery = true)
    Long getNextSequenceValue();
    List<Annonce> findAnnonceByUtilisateur(Utilisateur utilisateur);
    Annonce findAnnonceByIdAnnonceAndUtilisateur(String idAnnonce, Utilisateur utilisateur);
    List<Annonce> findAllByHistoriqueModificationAnnonceUtilisateurs(Utilisateur utilisateur);

    boolean existsByIdAnnonceIgnoreCase(String idAnnonce);
}
