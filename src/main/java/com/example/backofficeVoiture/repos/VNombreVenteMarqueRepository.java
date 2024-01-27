package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.VNombreVenteMarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface VNombreVenteMarqueRepository extends JpaRepository<VNombreVenteMarque,String> {

    @Query(value = "with part1 as\n" +
            "    (select nombre, id_marque, marque_nom, v.extract from v_nombre_vente_marque v where v.extract = cast (:year as numeric))\n" +
            "       select coalesce(part1.nombre, 0) nombre,\n" +
            "       m.id_marque,\n" +
            "       m.nom marque_nom,\n" +
            "       coalesce(part1.extract, cast (:year as numeric)) extract\n" +
            "       from marque m left join part1 on m.id_marque = part1.id_marque;", nativeQuery = true)
    List<VNombreVenteMarque> getNombreVenteParAnneeParMarque(@Param("year") String year);
}
