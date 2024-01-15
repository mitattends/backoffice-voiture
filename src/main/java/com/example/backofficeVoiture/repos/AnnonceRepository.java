package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnnonceRepository extends JpaRepository<Annonce, String> {
}
