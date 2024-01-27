package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "axe_possible_values")
public class AxePossibleValues {

    @Id
    @Column(nullable = false, updatable = false, length = 20, name = "id_axe_possible_values")
    private String idAxePossibleValues;

    @Column(length = 200)
    private String value;

    @Column(name = "valeur_numerique")
    private Integer valeurNumerique;

    @ManyToOne()
    @JoinColumn(name = "id_modele")
    @JsonBackReference
    private Modele modele;

    @ManyToOne()
    @JoinColumn(name = "id_axe")
    @JsonBackReference
    public AxeDetails axe;

    @Column(name = "id_value")
    public Integer idValue;


    @Transient
    String idAxe;

    @Transient
    public String idModele;

    public String getIdAxe() {
        return idAxe;
    }

    public void setIdAxe(String idAxe) {
        this.idAxe = idAxe;
    }

    public String getIdAxePossibleValues() {
        return idAxePossibleValues;
    }

    public void setIdAxePossibleValues(final String idAxePossibleValues) {
        this.idAxePossibleValues = idAxePossibleValues;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(final Modele modele) {
        this.modele = modele;
    }
    public AxeDetails getAxe() {
        return axe;
    }

    public void setAxe(final AxeDetails axe) {
        this.axe = axe;
    }

    public void setIdAxePossibleValues(Long value){
        String sequeceString = Utilities.buildStringSequence("APV", 5, value);
        this.setIdAxePossibleValues(sequeceString);
    }

    public Integer getValeurNumerique() {
        return valeurNumerique;
    }

    public void setValeurNumerique(Integer valeurNumerique) {
        this.valeurNumerique = valeurNumerique;
    }

    public Integer getIdValue() {
        return idValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }

    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }
}
