package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @JsonIgnore
    private Set<AxePossibleValues> axeAxePossibleValueses;

    @OneToMany(mappedBy = "axe")
    @JsonManagedReference
    @JsonIgnore
    private Set<DetailsModele> axeDetailsModeles;

    @JsonFormat
    @Transient
    List<AxePossibleValues> possibleValeur = new ArrayList<>(); // possible valeur
    public void addData(AxePossibleValues axePossibleValues){
        this.possibleValeur.add(axePossibleValues);
    }
    public void setPossibleValeur(List<AxePossibleValues> possibleValeur) {
        this.possibleValeur = possibleValeur;
    }

    public Set<AxePossibleValues> getAxeAxePossibleValueses() {
        return axeAxePossibleValueses;
    }

    public void setAxePossibleValuesList(List<AxePossibleValues> axePossibleValuesList){

    }

    // set the value of axe details for an object
    /*public void setAxePossibleValuesDetails(Set<AxePossibleValues> axeAxePossibleValueses){
        this.axeAxePossibleValueses = axeAxePossibleValueses;
    }*/

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
/*
    public Set<AxePossibleValues> getAxeAxePossibleValueses() {
        return axeAxePossibleValueses;
    }

    public void setAxeAxePossibleValueses(final Set<AxePossibleValues> axeAxePossibleValueses) {
        this.axeAxePossibleValueses = axeAxePossibleValueses;
    }
*/

    public Set<DetailsModele> getAxeDetailsModeles() {
        return axeDetailsModeles;
    }

    public void setAxeDetailsModeles(final Set<DetailsModele> axeDetailsModeles) {
        this.axeDetailsModeles = axeDetailsModeles;
    }

    public void setIdAxeDetails(Long value){
        String sequeceString = Utilities.buildStringSequence("AXE", 5, value);
        this.setIdAxe(sequeceString);
    }
}
