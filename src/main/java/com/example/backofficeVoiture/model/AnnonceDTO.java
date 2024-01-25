package com.example.backofficeVoiture.model;
import java.time.OffsetDateTime;
import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AnnonceDTO {

    @Size(max = 20)
    private String idAnnonce;

    @Size(max = 10)
    private String annee;

    private Double kilometrage;

    private OffsetDateTime dateAnnonce;

    @Size(max = 200)
    private String description;

    private Integer etat;

    @Size(max = 20)
    private String utilisateur;

    private List<String> historiqueModificationAnnonceUtilisateurs;

}
