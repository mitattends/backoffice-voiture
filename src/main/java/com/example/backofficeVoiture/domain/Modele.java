package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "modele")
public class Modele {

    @Column(nullable = false, updatable = false, length = 20, name = "id_modele")
    @Id
    private String idModele;

    @Column(length = 200)
    private String nom;

    @ManyToOne()
    @JoinColumn(name = "id_marque")
    @JsonBackReference
    private Marque marque;
    @Transient
    public String idMarque;

    @OneToMany(mappedBy = "modele", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<AxePossibleValues> modeleAxePossibleValueses;

    @Transient
    List<AxeDetails> axeDetailsList;

    public void setAxeDetailsAxeList(List<AxeDetails> axeDetailsList) {
        this.axeDetailsList = axeDetailsList;
    }

    public void setAxeDetailsListPossibleValues(List<AxePossibleValues> axePossibleValues){
        for (AxeDetails ad: this.axeDetailsList) {
            for (AxePossibleValues axv: axePossibleValues) {
                if(ad.getIdAxe().equals(axv.getAxe().getIdAxe())){
                    System.out.println("anatiny "+axv.getModele().idModele);
                    System.out.println("code "+this.idModele);
                    axv.idAxe = axv.getAxe().getIdAxe();
                    axv.idModele = axv.getModele().idModele;
                    ad.addData(axv);
                }
            }
        }
    }

    public void rectifyData(){
        for (AxeDetails ad: this.axeDetailsList) {
            List<AxePossibleValues> axePossibleValues = new ArrayList<>();
            for (AxePossibleValues axv: ad.possibleValeur) {
                if(axv.getModele().getIdModele().equals(this.idModele)){
                    System.out.println("rectification valeur"+axv.getModele().getIdModele()+" axe"+this.idModele);
                    axePossibleValues.add(axv);
                }
            }
            ad.setPossibleValeur(axePossibleValues);
        }
    }
    public List<AxeDetails> getAxeDetailsList() {
        return axeDetailsList;
    }

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

    public void setIdModele(Long value){
        String sequeceString = Utilities.buildStringSequence("MD", 5, value);
        this.setIdModele(sequeceString);
    }
}
