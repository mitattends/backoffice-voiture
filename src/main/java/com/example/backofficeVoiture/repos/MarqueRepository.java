package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Marque;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarqueRepository extends JpaRepository<Marque, String> {
}
