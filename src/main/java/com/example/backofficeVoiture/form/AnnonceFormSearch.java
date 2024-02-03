package com.example.backofficeVoiture.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AnnonceFormSearch {

    String anneeSup;
    String anneeInf;
    String prixSup;
    String prixInf;
    String marque;
    List<AxeValues> axeValues;

    public String sqlValues(){
        String sql = "";
        for (AxeValues ax: axeValues){
            sql += ax.sqlValue() + ",";
        }
        return sql.substring(0, sql.length()-1);
    }
}
