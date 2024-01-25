package com.example.backofficeVoiture.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DetailsModeleDTO {

    private String idDetailsModel;

    @Size(max = 200)
    private String value;

    @Size(max = 20)
    private String idModele;

    @Size(max = 20)
    private String annonce;

    @Size(max = 20)
    private String axe;

}
