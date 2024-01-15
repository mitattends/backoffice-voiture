package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
}
