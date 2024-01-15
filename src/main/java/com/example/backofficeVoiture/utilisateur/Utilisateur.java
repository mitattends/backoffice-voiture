package com.example.backofficeVoiture.utilisateur;

import com.example.backofficeVoiture.historiqueModificationAnnonce.HistoriqueModificationAnnonce;
import com.example.backofficeVoiture.annonce.Annonce;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Utilisateur {
    private String idUtilisateur;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String motDePasse;
    private Collection<Annonce> annoncesByIdUtilisateur;
    private Collection<HistoriqueModificationAnnonce> historiqueModificationAnnoncesByIdUtilisateur;

    @Id
    @Column(name = "id_utilisateur", nullable = false, length = 20)
    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 200)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 200)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "date_naissance", nullable = true)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mot_de_passe", nullable = true, length = 200)
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(idUtilisateur, that.idUtilisateur) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(dateNaissance, that.dateNaissance) && Objects.equals(email, that.email) && Objects.equals(motDePasse, that.motDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur, nom, prenom, dateNaissance, email, motDePasse);
    }

    @OneToMany(mappedBy = "utilisateurByIdUtilisateur", fetch = FetchType.LAZY)
    public Collection<Annonce> getAnnoncesByIdUtilisateur() {
        return annoncesByIdUtilisateur;
    }

    public void setAnnoncesByIdUtilisateur(Collection<Annonce> annoncesByIdUtilisateur) {
        this.annoncesByIdUtilisateur = annoncesByIdUtilisateur;
    }

    @OneToMany(mappedBy = "utilisateurByIdUtilisateur", fetch = FetchType.LAZY)
    public Collection<HistoriqueModificationAnnonce> getHistoriqueModificationAnnoncesByIdUtilisateur() {
        return historiqueModificationAnnoncesByIdUtilisateur;
    }

    public void setHistoriqueModificationAnnoncesByIdUtilisateur(Collection<HistoriqueModificationAnnonce> historiqueModificationAnnoncesByIdUtilisateur) {
        this.historiqueModificationAnnoncesByIdUtilisateur = historiqueModificationAnnoncesByIdUtilisateur;
    }
}
