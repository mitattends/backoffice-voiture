package com.example.backofficeVoiture.historiqueModificationAnnonce;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueModificationAnnonceRepository extends CrudRepository<HistoriqueModificationAnnonce, Long> {
}