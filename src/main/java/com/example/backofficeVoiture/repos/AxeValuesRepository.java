package com.example.backofficeVoiture.repos;

import java.util.List;

import com.example.backofficeVoiture.domain.AxeValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AxeValuesRepository extends JpaRepository<AxeValues, Integer> {
    List<AxeValues> findAxeValuesByIdAxe(String idAxe);

    AxeValues findAxeValuesByIdValue(Integer idValue);
}
