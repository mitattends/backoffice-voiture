package com.example.backofficeVoiture.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AnnonceFormSearch {

    @NotBlank(message = "Aucune annee choisie")
    String anneeSup;
    @NotBlank(message = "Annee invalide")
    String anneeInf;
    @NotBlank(message = "Prix invalide")
    String prixSup;
    @NotBlank(message = "Prix invalide")
    String prixInf;
    @NotBlank(message = "Marque invalide")
    String marque;
    List<AxeValues> axeValues;

    public String sqlValues(){
        String sql = "";
        for (AxeValues ax: axeValues){
            if(ax != null){
                sql += ax.sqlValue() + ",";
            }
        }
        return sql.substring(0, sql.length()-1);
    }
}
