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
}
