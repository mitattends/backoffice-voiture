package com.example.backofficeVoiture.models.modele;

import com.example.backofficeVoiture.models.marque.Marque;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String nom;

    @ManyToOne
    @JoinColumn(name = "marque_id")
    Marque marque;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Modele() {
    }

    public Modele(String nom, Marque marque) {
        this.nom = nom;
        this.setMarque(marque);
    }

    public Modele(Integer id, String nom, Marque marque){
        this.setId(id);
        this.setNom(nom);
        this.setMarque(marque);
    }

}
