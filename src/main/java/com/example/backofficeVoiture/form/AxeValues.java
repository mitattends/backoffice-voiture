package com.example.backofficeVoiture.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AxeValues implements Serializable {

    public String index;
    public String value;

    public AxeValues(){}
    public AxeValues(String index, String value) {
        this.index = index;
        this.value = value;
    }

    public String sqlValue(){
        return value;
    }
}
