package com.example.backofficeVoiture.models.admin;

import com.example.backofficeVoiture.util.Utilities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrateur")
public class Administrateur {

    @Id
    @Column(name = "idadministrateur")
    String idAdministrateur;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "email")
    String email;
    @Column(name = "motdepasse")
    String motDePasse;

    public Administrateur(){}
    public Administrateur(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(String idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public void setIdAdministrateur(Long value){
        String sequeceString = Utilities.buildStringSequence("AD", 5, value);
        System.out.println(sequeceString);
        this.setIdAdministrateur(sequeceString);
    }
}