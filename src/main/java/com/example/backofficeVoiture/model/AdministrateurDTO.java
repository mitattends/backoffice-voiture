package com.example.backofficeVoiture.model;

import com.example.backofficeVoiture.domain.Administrateur;
import com.example.backofficeVoiture.domain.VNombreAnnonceParMoisParAnnee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministrateurDTO {

    String nom;
    String prenom;
    String email;
    String motDePasse;

    public Administrateur getAdministrateur(){
        return new Administrateur(this.nom, this.prenom, this.email, this.motDePasse);
    }
}
