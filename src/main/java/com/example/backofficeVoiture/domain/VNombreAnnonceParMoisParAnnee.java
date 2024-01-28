package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_nombre_annonce_par_mois_par_annee", schema = "public", catalog = "voiture")
public class VNombreAnnonceParMoisParAnnee {
    @Basic
    @Column(name = "nombre")
    private Long nombre;
    @Id
    @Column(name = "id_mois")
    private Integer idMois;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "extract")
    private BigInteger extract;
    @Basic
    @Column(name = "etat")
    private Integer etat;

    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }

    public Integer getIdMois() {
        return idMois;
    }

    public void setIdMois(Integer idMois) {
        this.idMois = idMois;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigInteger getExtract() {
        return extract;
    }

    public void setExtract(BigInteger extract) {
        this.extract = extract;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VNombreAnnonceParMoisParAnnee that = (VNombreAnnonceParMoisParAnnee) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(idMois, that.idMois) && Objects.equals(nom, that.nom) && Objects.equals(extract, that.extract) && Objects.equals(etat, that.etat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, idMois, nom, extract, etat);
    }

    @Entity
    @Table(name = "administrateur")
    public static class Administrateur {

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
}
