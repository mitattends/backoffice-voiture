package com.example.backofficeVoiture.marque;

import com.example.backofficeVoiture.modele.Modele;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Marque {

    private String idMarque;
    private String nom;
    private Collection<Modele> modelesByIdMarque;

    @Id
    @Column(name = "id_marque", length = 20)
    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 200)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque = (Marque) o;
        return Objects.equals(idMarque, marque.idMarque) && Objects.equals(nom, marque.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarque, nom);
    }

    @OneToMany(mappedBy = "marqueByIdMarque", fetch = FetchType.LAZY)
    public Collection<Modele> getModelesByIdMarque() {
        return modelesByIdMarque;
    }

    public void setModelesByIdMarque(Collection<Modele> modelesByIdMarque) {
        this.modelesByIdMarque = modelesByIdMarque;
    }
}
