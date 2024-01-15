package com.example.backofficeVoiture.modele;

import com.example.backofficeVoiture.AxePossibleValues.AxePossibleValues;
import com.example.backofficeVoiture.detailsModele.DetailsModele;
import com.example.backofficeVoiture.marque.Marque;
import com.example.backofficeVoiture.annonce.Annonce;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Modele {
    private String idModele;
    private String nom;
    private String idMarque;
    private Collection<Annonce> annoncesByIdModele;
    private Collection<Annonce> annoncesByIdModele_0;
    private Collection<AxePossibleValues> axePossibleValuesByIdModele;
    private Collection<DetailsModele> detailsModelesByIdModele;
    private Marque marqueByIdMarque;

    @Id
    @Column(name = "id_modele", nullable = false, length = 20)
    public String getIdModele() {
        return idModele;
    }

    public void setIdModele(String idModele) {
        this.idModele = idModele;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 200)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
/*
    @Basic
    @Column(name = "id_marque", nullable = true, length = 20)
    public String getIdMarque() {
        return idMarque;
    }
*/
    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modele modele = (Modele) o;
        return Objects.equals(idModele, modele.idModele) && Objects.equals(nom, modele.nom) && Objects.equals(idMarque, modele.idMarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModele, nom, idMarque);
    }

    /*
    @OneToMany(mappedBy = "modeleByIdModele", fetch = FetchType.LAZY)
    public Collection<Annonce> getAnnoncesByIdModele() {
        return annoncesByIdModele;
    }*/

    public void setAnnoncesByIdModele(Collection<Annonce> annoncesByIdModele) {
        this.annoncesByIdModele = annoncesByIdModele;
    }

    public void setAnnoncesByIdModele_0(Collection<Annonce> annoncesByIdModele_0) {
        this.annoncesByIdModele_0 = annoncesByIdModele_0;
    }

    @OneToMany(mappedBy = "modeleByIdModele", fetch = FetchType.LAZY)
    public Collection<AxePossibleValues> getAxePossibleValuesByIdModele() {
        return axePossibleValuesByIdModele;
    }

    public void setAxePossibleValuesByIdModele(Collection<AxePossibleValues> axePossibleValuesByIdModele) {
        this.axePossibleValuesByIdModele = axePossibleValuesByIdModele;
    }

/*    @OneToMany(mappedBy = "modeleByIdModele", fetch = FetchType.LAZY)
    public Collection<DetailsModele> getDetailsModelesByIdModele() {
        return detailsModelesByIdModele;
    }
*/
    public void setDetailsModelesByIdModele(Collection<DetailsModele> detailsModelesByIdModele) {
        this.detailsModelesByIdModele = detailsModelesByIdModele;
    }

    @ManyToOne
    @JoinColumn(name = "id_marque", referencedColumnName = "id_marque")
    public Marque getMarqueByIdMarque() {
        return marqueByIdMarque;
    }

    public void setMarqueByIdMarque(Marque marqueByIdMarque) {
        this.marqueByIdMarque = marqueByIdMarque;
    }
}
