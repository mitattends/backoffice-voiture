package com.example.backofficeVoiture.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AxePossibleValuesDTO {

    @Size(max = 20)
    private String idAxePossibleValues;

    @Size(max = 200)
    private String value;

    @Size(max = 20)
    private String modele;

    @Size(max = 20)
    private String axe;

}
