package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.VNombreAnnonceParMoisParAnnee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends JpaRepository<VNombreAnnonceParMoisParAnnee.Administrateur, String> {
    @Query(value = "SELECT NEXTVAL('seq_administrateur')", nativeQuery = true)
    Long getNextSequenceValue();
    VNombreAnnonceParMoisParAnnee.Administrateur findAdministrateurByEmailAndMotDePasse(String email, String motDePasse);
}
