package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_nombre_vente_marque", schema = "public", catalog = "voiture")
public class VNombreVenteMarque {
    @Basic
    @Column(name = "nombre")
    private Long nombre;
    @Id
    @Column(name = "id_marque")
    private String idMarque;
    @Basic
    @Column(name = "marque_nom")
    private String marqueNom;
    @Basic
    @Column(name = "extract")
    private BigInteger extract;

    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarqueNom() {
        return marqueNom;
    }

    public void setMarqueNom(String marqueNom) {
        this.marqueNom = marqueNom;
    }

    public BigInteger getExtract() {
        return extract;
    }

    public void setExtract(BigInteger extract) {
        this.extract = extract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VNombreVenteMarque that = (VNombreVenteMarque) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(idMarque, that.idMarque) && Objects.equals(marqueNom, that.marqueNom) && Objects.equals(extract, that.extract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, idMarque, marqueNom, extract);
    }
}
