package com.example.backofficeVoiture.detailsModele;

import com.example.backofficeVoiture.AxeDetails.AxeDetails;
import com.example.backofficeVoiture.modele.Modele;
import com.example.backofficeVoiture.annonce.Annonce;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "details_modele", schema = "public", catalog = "postgres")
public class DetailsModele {
    private String idModele;
    private String idAxe;
    private String value;
    private String idAnnonce;
    private AxeDetails axeDetailsByIdAxe;
    private Annonce annonceByIdAnnonce;

    @Id
    @Basic
    @Column(name = "id_modele", nullable = true, length = 20)
    public String getIdModele() {
        return idModele;
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

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailsModele that = (DetailsModele) o;
        return Objects.equals(idModele, that.idModele) && Objects.equals(idAxe, that.idAxe) && Objects.equals(value, that.value) && Objects.equals(idAnnonce, that.idAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModele, idAxe, value, idAnnonce);
    }


    @ManyToOne
    @JoinColumn(name = "id_axe", referencedColumnName = "id_axe")
    public AxeDetails getAxeDetailsByIdAxe() {
        return axeDetailsByIdAxe;
    }

    public void setAxeDetailsByIdAxe(AxeDetails axeDetailsByIdAxe) {
        this.axeDetailsByIdAxe = axeDetailsByIdAxe;
    }

    @ManyToOne
    @JoinColumn(name = "id_annonce", referencedColumnName = "id_annonce")
    public Annonce getAnnonceByIdAnnonce() {
        return annonceByIdAnnonce;
    }

    public void setAnnonceByIdAnnonce(Annonce annonceByIdAnnonce) {
        this.annonceByIdAnnonce = annonceByIdAnnonce;
    }
}
