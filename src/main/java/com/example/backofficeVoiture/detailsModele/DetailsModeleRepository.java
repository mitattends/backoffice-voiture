package com.example.backofficeVoiture.detailsModele;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsModeleRepository extends CrudRepository<DetailsModele, String> {

}
