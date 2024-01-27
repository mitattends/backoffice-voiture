package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "axe_values", schema = "public", catalog = "voiture")
public class AxeValues {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_value")
    private int idValue;
    @Basic
    @Column(name = "label")
    private String label;
    @Basic
    @Column(name = "id_axe")
    private String idAxe;

    public int getIdValue() {
        return idValue;
    }

    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIdAxe() {
        return idAxe;
    }

    public void setIdAxe(String idAxe) {
        this.idAxe = idAxe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxeValues axeValues = (AxeValues) o;
        return idValue == axeValues.idValue && Objects.equals(label, axeValues.label) && Objects.equals(idAxe, axeValues.idAxe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValue, label, idAxe);
    }
}
