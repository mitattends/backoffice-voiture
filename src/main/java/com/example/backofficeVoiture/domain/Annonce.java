package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.service.AnnonceService;
import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Table(name = "annonce")
public class Annonce {

    @Id
    @Column(nullable = false, updatable = false, length = 20, name = "id_annonce")
    private String idAnnonce;

    @Column(length = 10)
    private String annee;

    @Column
    private Double kilometrage;

    @Column
    private OffsetDateTime dateAnnonce;

    @Column(length = 200)
    private String description;

    @Column
    private Integer etat;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modele")
    private Modele modele;
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur")
    @JsonBackReference
    private Utilisateur utilisateur;


    @OneToMany(mappedBy = "annonce")
    @JsonManagedReference
    private Set<DetailsModele> annonceDetailsModeles;

    @ManyToMany
    @JoinTable(
            name = "HistoriqueModificationAnnonce",
            joinColumns = @JoinColumn(name = "idAnnonce"),
            inverseJoinColumns = @JoinColumn(name = "idUtilisateur")
    )
    private Set<Utilisateur> historiqueModificationAnnonceUtilisateurs;

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(final String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(final String annee) {
        this.annee = annee;
    }

    public Double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(final Double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public OffsetDateTime getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(final OffsetDateTime dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(final Integer etat) {
        this.etat = etat;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(final Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
/*
    public Modele getModele() {
        return modele;
    }

    public void setModele(final Modele modele) {
        this.modele = modele;
    }*/

    public Set<DetailsModele> getAnnonceDetailsModeles() {
        return annonceDetailsModeles;
    }

    public void setAnnonceDetailsModeles(final Set<DetailsModele> annonceDetailsModeles) {
        this.annonceDetailsModeles = annonceDetailsModeles;
    }

    public Set<Utilisateur> getHistoriqueModificationAnnonceUtilisateurs() {
        return historiqueModificationAnnonceUtilisateurs;
    }

    public void setHistoriqueModificationAnnonceUtilisateurs(
            final Set<Utilisateur> historiqueModificationAnnonceUtilisateurs) {
        this.historiqueModificationAnnonceUtilisateurs = historiqueModificationAnnonceUtilisateurs;
    }

    public Annonce(){}
    public void setKilometrage(String kilometrage){
        try{
            this.setKilometrage(Double.valueOf(kilometrage));
        }
        catch (Exception e){
            throw e;
        }
    }

    public void setIdAnnonce(Long value){
        String sequeceString = Utilities.buildStringSequence("AN", 5, value);
        System.out.println(sequeceString);
        this.setIdAnnonce(sequeceString);
    }
}
