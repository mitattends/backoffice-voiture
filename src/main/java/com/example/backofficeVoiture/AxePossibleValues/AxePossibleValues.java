package com.example.backofficeVoiture.AxePossibleValues;

import com.example.backofficeVoiture.AxeDetails.AxeDetails;
import com.example.backofficeVoiture.modele.Modele;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "axe_possible_values", schema = "public", catalog = "postgres")
public class AxePossibleValues {
    private String idAxePossibleValues;
    private String idModele;
    private String idAxe;
    private String value;
    private Modele modeleByIdModele;
    private AxeDetails axeDetailsByIdAxe;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_axe_possible_values", nullable = false, length = 20)
    public String getIdAxePossibleValues() {
        return idAxePossibleValues;
    }

    public void setIdAxePossibleValues(String idAxePossibleValues) {
        this.idAxePossibleValues = idAxePossibleValues;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }
    public void setIdAxe(String idAxe) {
        this.idAxe = idAxe;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 200)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxePossibleValues that = (AxePossibleValues) o;
        return Objects.equals(idAxePossibleValues, that.idAxePossibleValues) && Objects.equals(idModele, that.idModele) && Objects.equals(idAxe, that.idAxe) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAxePossibleValues, idModele, idAxe, value);
    }

    @ManyToOne
    @JoinColumn(name = "id_modele", referencedColumnName = "id_modele")
    public Modele getModeleByIdModele() {
        return modeleByIdModele;
    }

    public void setModeleByIdModele(Modele modeleByIdModele) {
        this.modeleByIdModele = modeleByIdModele;
    }

    @ManyToOne
    @JoinColumn(name = "id_axe", referencedColumnName = "id_axe")
    public AxeDetails getAxeDetailsByIdAxe() {
        return axeDetailsByIdAxe;
    }

    public void setAxeDetailsByIdAxe(AxeDetails axeDetailsByIdAxe) {
        this.axeDetailsByIdAxe = axeDetailsByIdAxe;
    }
}
