package com.example.backofficeVoiture.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MarqueDTO {

    @Size(max = 20)
    private String idMarque;

    @Size(max = 200)
    private String nom;

}
