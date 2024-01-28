package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.VNombreVenteMarque;
import com.example.backofficeVoiture.domain.VNombreVenteModele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VNombreVenteModeleRepository extends JpaRepository<VNombreVenteModele, String> {
    @Query(value = "with part1 as\n" +
            "    (select nombre, id_modele, modele_nom, v.extract from v_nombre_vente_modele v where v.extract = cast (:year as numeric))\n" +
            "       select coalesce(part1.nombre, 0) nombre,\n" +
            "       m.id_modele,\n" +
            "       m.nom modele_nom,\n" +
            "       coalesce(part1.extract, cast (:year as numeric)) extract\n" +
            "       from modele m left join part1 on m.id_modele = part1.id_modele;", nativeQuery = true)
    List<VNombreVenteModele> getNombreVenteParAnneeParModele(@Param("year") String year);

}
