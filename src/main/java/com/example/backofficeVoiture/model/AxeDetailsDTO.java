package com.example.backofficeVoiture.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AxeDetailsDTO {

    @Size(max = 20)
    private String idAxe;

    @Size(max = 200)
    private String nom;

    String[] details;
}
