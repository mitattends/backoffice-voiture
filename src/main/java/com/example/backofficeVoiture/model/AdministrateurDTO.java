package com.example.backofficeVoiture.model;

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

    public VNombreAnnonceParMoisParAnnee.Administrateur getAdministrateur(){
        return new VNombreAnnonceParMoisParAnnee.Administrateur(this.nom, this.prenom, this.email, this.motDePasse);
    }
}
