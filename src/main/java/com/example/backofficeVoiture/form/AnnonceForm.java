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
    
    public void controlData() throws Exception {
        if(selectedModel == null || selectedModel == "") throw new Exception("Aucun model séléctionné");
        if(annee == null || annee == "") throw new Exception("Aucune année choisie");
        if(kilometrage == null || kilometrage == "") throw new Exception("Aucun kilometrage choisie");
        if(prix == null || prix == "") throw new Exception("Aucun prix choisie");
        if(description == null || description == "") throw new Exception("Description neglogé");
        if(image == null || image.length == 0) throw new Exception("Aucune photo envoyé");
        if(axeValues == null || axeValues.size() == 0) throw new Exception("Aucun parametre choisi");
    }
}

