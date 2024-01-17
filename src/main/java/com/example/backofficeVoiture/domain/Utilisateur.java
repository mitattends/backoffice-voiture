package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @Column(nullable = false, updatable = false, length = 20, name = "id_utilisateur")
    private String idUtilisateur;

    @Column(length = 200)
    private String nom;

    @Column(length = 200)
    private String prenom;

    @Column
    private LocalDate dateNaissance;

    @Column(length = 200)
    private String email;

    @Column(length = 200)
    private String motDePasse;

    @OneToMany(mappedBy = "utilisateur")
    @JsonManagedReference
    private Set<Annonce> utilisateurAnnonces;

    @ManyToMany(mappedBy = "historiqueModificationAnnonceUtilisateurs")
    private Set<Annonce> historiqueModificationAnnonceAnnonces;

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(final String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(final LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(final String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Set<Annonce> getUtilisateurAnnonces() {
        return utilisateurAnnonces;
    }

    public void setUtilisateurAnnonces(final Set<Annonce> utilisateurAnnonces) {
        this.utilisateurAnnonces = utilisateurAnnonces;
    }

    public Set<Annonce> getHistoriqueModificationAnnonceAnnonces() {
        return historiqueModificationAnnonceAnnonces;
    }

    public void setHistoriqueModificationAnnonceAnnonces(
            final Set<Annonce> historiqueModificationAnnonceAnnonces) {
        this.historiqueModificationAnnonceAnnonces = historiqueModificationAnnonceAnnonces;
    }


    public void setIdUtilisateur(Long value){
        String sequeceString = Utilities.buildStringSequence("USR", 5, value);
        this.setIdUtilisateur(sequeceString);
    }
    public void setDateNaissance(String dateNaissance) {
        try{
            LocalDate localDate = LocalDate.parse(dateNaissance);
            this.setDateNaissance(localDate);
        }
        catch (Exception e){
            throw e;
        }

    }

}
