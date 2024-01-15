package com.example.backofficeVoiture.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "details_modele")
public class DetailsModele {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_details_modele")
    private String idAxe;
    @Column(nullable = false, updatable = false, length = 200, name = "value")
    private String value;


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

}
