package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Annonce;
import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.domain.DetailsModele;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.form.AxeValues;
import com.example.backofficeVoiture.repos.AxeDetailsRepository;
import com.example.backofficeVoiture.repos.DetailsModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailsModelService {
    @Autowired
    DetailsModeleRepository detailsModeleRepository;
    @Autowired
    AxeDetailsRepository axeDetailsRepository;
    public void insert(AnnonceForm annonceForm, Annonce annonce){
        try{
            for(AxeValues axeValues : annonceForm.getAxeValues()){
                AxeDetails axeDetails = axeDetailsRepository.findAxeDetailsByIdAxe(axeValues.getIndex());
                DetailsModele detailsModele = new DetailsModele();
                detailsModele.setValue(axeValues.getValue());
                detailsModele.setAxe(axeDetails);
                detailsModele.setIdModel(annonceForm.getSelectedModel());
                detailsModele.setAnnonce(annonce);
                Long id = detailsModeleRepository.getNextSequenceValue();
                detailsModele.setIdDetailsModele(id);
                System.out.println("id "+detailsModele.getIdDetailsModele());
                detailsModeleRepository.save(detailsModele);
            }
        }catch (Exception e) {
            throw e;
        }
    }
}
