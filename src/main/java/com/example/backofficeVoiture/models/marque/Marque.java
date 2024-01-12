package com.example.backofficeVoiture.models.marque;

import java.util.List;

import com.example.backofficeVoiture.models.modele.Modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String nom;

    @OneToMany(mappedBy = "marque")
    List<Modele> modeles;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Marque() {
    }

    public Marque(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }

}
