package com.example.backofficeVoiture.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import  java.util.List;

@Getter
@Setter
public class ModeleDTO {

    @Size(max = 20)
    private String idModele;

    @Size(max = 200)
    private String nom;

    @Size(max = 20)
    private String marque;

    List<AxeValuesDTO> axes;
}
