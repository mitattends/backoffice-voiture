package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.domain.AxePossibleValues;
import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.repos.AxePossibleValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    AxePossibleValuesRepository axePossibleValuesRepository;

    public ModelService(AxePossibleValuesRepository axePossibleValuesRepository){
        this.axePossibleValuesRepository = axePossibleValuesRepository;
    }
    public void buildModele(List<Modele> modeleList, List<AxeDetails> axeDetailsList){
        for (Modele modele: modeleList) {
            modele.idMarque = modele.getMarque().getIdMarque();
            modele.setAxeDetailsAxeList(axeDetailsList);
            modele.setAxeDetailsListPossibleValues(axePossibleValuesRepository.getAxePossibleValuesByModele(modele));
            modele.rectifyData();
        }
    }
}
