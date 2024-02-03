package com.example.backofficeVoiture.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {

    String nomEnvoyeur;
    String idEnvoyeur;
    String nomReceveur;
    String idReceveur;
    String message;
    String dateEnvoie;
    String dateReception;
    String dateVue;
    String idAnnonce;
    AnnonceDTO annonceDTO;
}
