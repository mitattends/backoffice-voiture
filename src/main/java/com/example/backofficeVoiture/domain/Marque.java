package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "marque")
public class Marque {

    @Id
    @Column(nullable = false, updatable = false, length = 20, name = "id_marque")
    private String idMarque;

    @Column(length = 200)
    private String nom;

    @OneToMany(mappedBy = "marque", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Modele> marqueModeles;

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(final String idMarque) {
        this.idMarque = idMarque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public Set<Modele> getMarqueModeles() {
        return marqueModeles;
    }

    public void setMarqueModeles(final Set<Modele> marqueModeles) {
        this.marqueModeles = marqueModeles;
    }


    public void setIdMarque(Long value){
        String sequeceString = Utilities.buildStringSequence("MRQ", 5, value);
        this.setIdMarque(sequeceString);
    }
}
