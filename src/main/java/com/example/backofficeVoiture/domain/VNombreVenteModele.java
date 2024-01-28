package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_nombre_vente_modele", schema = "public", catalog = "voiture")
public class VNombreVenteModele {
    @Basic
    @Column(name = "nombre")
    private Long nombre;
    @Id
    @Column(name = "id_modele")
    private String idModele;
    @Basic
    @Column(name = "extract")
    private BigInteger extract;
    @Basic
    @Column(name = "modele_nom")
    private String modeleNom;


    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    public BigInteger getExtract() {
        return extract;
    }

    public void setExtract(BigInteger extract) {
        this.extract = extract;
    }

    public String getModeleNom() {
        return modeleNom;
    }

    public void setModeleNom(String modeleNom) {
        this.modeleNom = modeleNom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VNombreVenteModele that = (VNombreVenteModele) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(idModele, that.idModele) && Objects.equals(extract, that.extract) && Objects.equals(modeleNom, that.modeleNom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, idModele, extract, modeleNom);
    }
}
