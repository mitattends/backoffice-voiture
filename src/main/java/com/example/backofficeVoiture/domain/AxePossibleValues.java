package com.example.backofficeVoiture.domain;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modele")
    @JsonBackReference
    private Modele modele;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_axe")
    @JsonBackReference
    private AxeDetails axe;

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

}
