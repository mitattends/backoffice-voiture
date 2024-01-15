package com.example.backofficeVoiture.annonce;

import com.example.backofficeVoiture.detailsModele.DetailsModele;
import com.example.backofficeVoiture.historiqueModificationAnnonce.HistoriqueModificationAnnonce;
import com.example.backofficeVoiture.modele.Modele;
import com.example.backofficeVoiture.utilisateur.Utilisateur;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Annonce {
    private String idAnnonce;
    private String idModele;
    private String annee;
    private Double kilometrage;
    private Timestamp dateAnnonce;
    private String description;
    private Integer etat;
    private String idUtilisateur;
    private Modele modeleByIdModele;
    private Modele modeleByIdModele_0;
    private Utilisateur utilisateurByIdUtilisateur;
    private Collection<DetailsModele> detailsModelesByIdAnnonce;
    private Collection<HistoriqueModificationAnnonce> historiqueModificationAnnoncesByIdAnnonce;

    @Id
    @Column(name = "id_annonce", nullable = false, length = 20)
    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }


    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    @Basic
    @Column(name = "annee", nullable = true, length = 10)
    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Basic
    @Column(name = "kilometrage", nullable = true, precision = 0)
    public Double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Double kilometrage) {
        this.kilometrage = kilometrage;
    }

    @Basic
    @Column(name = "date_annonce", nullable = true)
    public Timestamp getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Timestamp dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "etat", nullable = true)
    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annonce annonce = (Annonce) o;
        return Objects.equals(idAnnonce, annonce.idAnnonce) && Objects.equals(idModele, annonce.idModele) && Objects.equals(annee, annonce.annee) && Objects.equals(kilometrage, annonce.kilometrage) && Objects.equals(dateAnnonce, annonce.dateAnnonce) && Objects.equals(description, annonce.description) && Objects.equals(etat, annonce.etat) && Objects.equals(idUtilisateur, annonce.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, idModele, annee, kilometrage, dateAnnonce, description, etat, idUtilisateur);
    }

    @ManyToOne
    @JoinColumn(name = "id_modele", referencedColumnName = "id_modele")
    public Modele getModeleByIdModele() {
        return modeleByIdModele;
    }

    public void setModeleByIdModele(Modele modeleByIdModele) {
        this.modeleByIdModele = modeleByIdModele;
    }

    public void setModeleByIdModele_0(Modele modeleByIdModele_0) {
        this.modeleByIdModele_0 = modeleByIdModele_0;
    }

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    public Utilisateur getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(Utilisateur utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }

    @OneToMany(mappedBy = "annonceByIdAnnonce")
    public Collection<DetailsModele> getDetailsModelesByIdAnnonce() {
        return detailsModelesByIdAnnonce;
    }

    public void setDetailsModelesByIdAnnonce(Collection<DetailsModele> detailsModelesByIdAnnonce) {
        this.detailsModelesByIdAnnonce = detailsModelesByIdAnnonce;
    }

    @OneToMany(mappedBy = "annonceByIdAnnonce")
    public Collection<HistoriqueModificationAnnonce> getHistoriqueModificationAnnoncesByIdAnnonce() {
        return historiqueModificationAnnoncesByIdAnnonce;
    }

    public void setHistoriqueModificationAnnoncesByIdAnnonce(Collection<HistoriqueModificationAnnonce> historiqueModificationAnnoncesByIdAnnonce) {
        this.historiqueModificationAnnoncesByIdAnnonce = historiqueModificationAnnoncesByIdAnnonce;
    }
}
