package com.example.backofficeVoiture.domain;

import com.example.backofficeVoiture.util.Utilities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "details_modele")
public class DetailsModele {

    @Id
    @Column(name = "id_details_model")
    private String idDetailsModele;
    @Column(nullable = false, updatable = false, length = 200, name = "value")
    private String value;

    @Column(name = "id_modele")
    private String idModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_annonce")
    @JsonBackReference
    private Annonce annonce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_axe")
    @JsonBackReference
    private AxeDetails axe;

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }


    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(final Annonce annonce) {
        this.annonce = annonce;
    }

    public AxeDetails getAxe() {
        return axe;
    }

    public void setAxe(final AxeDetails axe) {
        this.axe = axe;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdDetailsModele(String idAxeDetails) {
        this.idDetailsModele = idAxeDetails;
    }

    public String getIdDetailsModele() {
        return idDetailsModele;
    }

    public void setIdDetailsModele(Long id){
        String sequeceString = Utilities.buildStringSequence("D", 5, id);
        this.setIdDetailsModele(sequeceString);
    }
}
