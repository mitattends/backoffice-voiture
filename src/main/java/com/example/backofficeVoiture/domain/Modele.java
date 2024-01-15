package com.example.backofficeVoiture.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity(name = "modele")
public class Modele {

    @Column(nullable = false, updatable = false, length = 20, name = "id_modele")
    @Id
    private String idModele;

    @Column(length = 200)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marque")
    @JsonBackReference
    private Marque marque;

    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<AxePossibleValues> modeleAxePossibleValueses;
/*
    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY)
    private Set<Annonce> modeleAnnonces;
*/

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(final String idModele) {
        this.idModele = idModele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(final Marque marque) {
        this.marque = marque;
    }

    public Set<AxePossibleValues> getModeleAxePossibleValueses() {
        return modeleAxePossibleValueses;
    }

    public void setModeleAxePossibleValueses(
            final Set<AxePossibleValues> modeleAxePossibleValueses) {
        this.modeleAxePossibleValueses = modeleAxePossibleValueses;
    }
/*
    public Set<Annonce> getModeleAnnonces() {
        return modeleAnnonces;
    }

    public void setModeleAnnonces(final Set<Annonce> modeleAnnonces) {
        this.modeleAnnonces = modeleAnnonces;
    }
*/
}
