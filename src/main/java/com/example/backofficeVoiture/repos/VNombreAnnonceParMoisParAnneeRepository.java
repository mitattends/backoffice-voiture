package com.example.backofficeVoiture.repos;

import com.example.backofficeVoiture.domain.VNombreAnnonceParMoisParAnnee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VNombreAnnonceParMoisParAnneeRepository extends JpaRepository<VNombreAnnonceParMoisParAnnee, Integer> {
    @Query(value = "insert into photo(text, id_annonce) values :param", nativeQuery = true)
    void insertMultiplePhoto(@Param("param") String param);

    @Query(value = "with part1 as \n" +
            "    (select \n" +
            "         nombre, \n" +
            "         id_mois, \n" +
            "         nom, \n" +
            "         coalesce(v.extract, cast( :target as numeric) ) annee, \n" +
            "         etat \n" +
            "    from v_nombre_annonce_par_mois_par_annee v where v.extract = cast( :target as numeric))\n" +
            "select coalesce(part1.nombre, 0) nombre , m.id_mois id_mois, m.nom nom, coalesce(part1.annee, cast(:target as numeric)) extract, etat\n" +
            "from mois m left join part1 on m.id_mois = part1.id_mois",nativeQuery = true)
    List<VNombreAnnonceParMoisParAnnee> nombreAnnonceParMoisParAnnee(@Param("target") String target);
}
