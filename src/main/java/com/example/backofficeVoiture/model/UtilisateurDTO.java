package com.example.backofficeVoiture.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UtilisateurDTO {

    @Size(max = 20)
    private String idUtilisateur;

    @Size(max = 200)
    private String nom;

    @Size(max = 200)
    private String prenom;

    private LocalDate dateNaissance;

    @Size(max = 200)
    private String email;

    @Size(max = 200)
    private String motDePasse;

}
