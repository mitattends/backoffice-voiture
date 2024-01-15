package com.example.backofficeVoiture.AxeDetails;

import com.example.backofficeVoiture.AxePossibleValues.AxePossibleValues;
import com.example.backofficeVoiture.detailsModele.DetailsModele;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "axe_details", schema = "public", catalog = "postgres")
public class AxeDetails {
    private String idAxe;
    private String nom;
    private Collection<AxePossibleValues> axePossibleValuesByIdAxe;
    private Collection<DetailsModele> detailsModelesByIdAxe;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_axe", nullable = false, length = 20)
    public String getIdAxe() {
        return idAxe;
    }

    public void setIdAxe(String idAxe) {
        this.idAxe = idAxe;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 200)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxeDetails that = (AxeDetails) o;
        return Objects.equals(idAxe, that.idAxe) && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAxe, nom);
    }

    @OneToMany(mappedBy = "axeDetailsByIdAxe")
    public Collection<AxePossibleValues> getAxePossibleValuesByIdAxe() {
        return axePossibleValuesByIdAxe;
    }

    public void setAxePossibleValuesByIdAxe(Collection<AxePossibleValues> axePossibleValuesByIdAxe) {
        this.axePossibleValuesByIdAxe = axePossibleValuesByIdAxe;
    }

    @OneToMany(mappedBy = "axeDetailsByIdAxe")
    public Collection<DetailsModele> getDetailsModelesByIdAxe() {
        return detailsModelesByIdAxe;
    }

    public void setDetailsModelesByIdAxe(Collection<DetailsModele> detailsModelesByIdAxe) {
        this.detailsModelesByIdAxe = detailsModelesByIdAxe;
    }
}
