package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.AxePossibleValues;
import com.example.backofficeVoiture.domain.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AxePossibleValuesRepository extends JpaRepository<AxePossibleValues, String> {
    //AxePossibleValues getAxePossibleValuesByModele(Modele modele);
    @Query(value = "SELECT NEXTVAL('seq_axe_possible_values')", nativeQuery = true)
    Long getNextSequenceValue();
    List<AxePossibleValues> getAxePossibleValuesByModele(Modele modele);

    boolean existsByIdAxePossibleValuesIgnoreCase(String idAxePossibleValues);
}
