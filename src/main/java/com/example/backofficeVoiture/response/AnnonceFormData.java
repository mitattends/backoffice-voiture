package com.example.backofficeVoiture.response;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.domain.Modele;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AnnonceFormData {
    Set<Marque> marques;
    Set<Modele> models;

    public void setMarques(Set<Marque> marques) {
        this.marques = marques;
    }

    public Set<Marque> getMarques() {
        return marques;
    }

    public void setModels(Set<Modele> models) {
        this.models = models;
    }

    public Set<Modele> getModels() {
        return models;
    }
}
