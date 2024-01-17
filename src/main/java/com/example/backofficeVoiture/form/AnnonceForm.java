package com.example.backofficeVoiture.form;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AnnonceForm {

    String selectedModel;
    String annee;
    String kilometrage;
    String prix;
    String description;
    String[] image;
    List<AxeValues> axeValues;
    public AnnonceForm(){}
    public AnnonceForm(String selectedModel, String annee, String kilometrage, String prix, String description, List<String> image, List<String> axeValues, String token) {
        this.selectedModel = selectedModel;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.description = description;   }
}

