package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, String> {
    @Query(value = "SELECT NEXTVAL('seq_marque')", nativeQuery = true)
    Long getNextSequenceValue();
}
