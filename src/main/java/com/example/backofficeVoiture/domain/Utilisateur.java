package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Column(length = 200)
    private String motDePasse;

    @Column
    Integer sexe;

    @OneToMany(mappedBy = "utilisateur")
    @JsonManagedReference
    @JsonIgnore
    private Set<Annonce> utilisateurAnnonces;

    @ManyToMany(mappedBy = "historiqueModificationAnnonceUtilisateurs")
    @JsonIgnore
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
        System.out.println("date "+ dateNaissance);
        // Text '2024-01-17T21:00:00.000Z
        try{
            dateNaissance = dateNaissance.split("T")[0];
            System.out.println("date naissance "+dateNaissance);
            LocalDate localDate = LocalDate.parse(dateNaissance);
            this.setDateNaissance(localDate);
        }
        catch (Exception e){
            throw e;
        }

    }

    public void setSexe(Integer sexe) {
        this.sexe = sexe;
    }

    public Integer getSexe() {
        return sexe;
    }
}
