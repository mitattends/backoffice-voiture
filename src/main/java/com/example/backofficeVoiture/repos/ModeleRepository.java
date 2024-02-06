package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, String> {
    @Query(value = "SELECT NEXTVAL('seq_modele')", nativeQuery = true)
    Long getNextSequenceValue();

    boolean existsByIdModeleIgnoreCase(String idModele);

    @Query(value = "select count(id_modele) as nombre, id_modele from axe_possible_values where id_value in\n" +
            "                                  (:sql)" +
            "    group by id_modele order by nombre", nativeQuery = true)
    HashMap<Integer, String> findModeleByIdValue(@Param("sql") String sql);
}
