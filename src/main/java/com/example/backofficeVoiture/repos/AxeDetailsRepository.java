package com.example.backofficeVoiture.repos;


import com.example.backofficeVoiture.domain.AxeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AxeDetailsRepository extends JpaRepository<AxeDetails, String> {
    @Query(value = "SELECT NEXTVAL('seq_axe_details')", nativeQuery = true)
    Long getNextSequenceValue();
    AxeDetails findAxeDetailsByIdAxe(String idAxe);
    boolean existsByIdAxeIgnoreCase(String idAxe);

}
