package com.example.backofficeVoiture.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "axe_details")
public class AxeDetails {

    @Id
    @Column(nullable = false, updatable = false, length = 20, name = "id_axe")
    private String idAxe;

    @Column(length = 200)
    private String nom;

    @OneToMany(mappedBy = "axe")
    @JsonManagedReference
    private Set<AxePossibleValues> axeAxePossibleValueses;

    @OneToMany(mappedBy = "axe")
    @JsonManagedReference
    private Set<DetailsModele> axeDetailsModeles;

    public String getIdAxe() {
        return idAxe;
    }

    public void setIdAxe(final String idAxe) {
        this.idAxe = idAxe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public Set<AxePossibleValues> getAxeAxePossibleValueses() {
        return axeAxePossibleValueses;
    }

    public void setAxeAxePossibleValueses(final Set<AxePossibleValues> axeAxePossibleValueses) {
        this.axeAxePossibleValueses = axeAxePossibleValueses;
    }

    public Set<DetailsModele> getAxeDetailsModeles() {
        return axeDetailsModeles;
    }

    public void setAxeDetailsModeles(final Set<DetailsModele> axeDetailsModeles) {
        this.axeDetailsModeles = axeDetailsModeles;
    }

}
