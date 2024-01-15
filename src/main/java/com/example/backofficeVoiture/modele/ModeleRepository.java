package com.example.backofficeVoiture.modele;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends CrudRepository<Modele, String> {
}
