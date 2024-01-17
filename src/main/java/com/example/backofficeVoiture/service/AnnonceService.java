package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.*;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.repos.*;
import com.example.backofficeVoiture.response.AnnonceFormData;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AnnonceService {
    @Autowired
    MarqueRepository marqueRepository;
    @Autowired
    ModeleRepository modeleRepository;
    @Autowired
    AxeDetailsRepository axeDetailsRepository;
    @Autowired
    AxePossibleValuesRepository axePossibleValuesRepository;
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    PhotoService photoService;
    @Autowired
    DetailsModelService detailsModelService;
    @Autowired
    UtilisateurService utilisateurService;
    public ApiResponse insererAnnonce(AnnonceForm annonceForm){
        System.out.println("tafiditra");
        ApiResponse apiResponse = new ApiResponse();
        try{
            Annonce annonce = new Annonce();
            annonce.setIdAnnonce(annonceRepository.getNextSequenceValue());
            annonce.setAnnee(annonceForm.getAnnee());
            annonce.setKilometrage(annonceForm.getKilometrage());
            annonce.setDescription(annonceForm.getDescription());
            annonce.setEtat(10);
            annonce.setUtilisateur(utilisateurService.getUserById(annonceForm.getIdUtilisateur()));
            annonceRepository.save(annonce);
            photoService.insertMultiplePhoto(annonceForm, annonce);
            detailsModelService.insert(annonceForm, annonce);
            annonceRepository.flush();
            apiResponse.setMessage("success");
        }
        catch (Exception e){
            e.printStackTrace();
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse annonceFormData(){
        ApiResponse apiResponse = new ApiResponse();
        List<Marque> marques = marqueRepository.findAll();
        List<Modele> modeleList = modeleRepository.findAll();
        List<AxeDetails> axeDetailsList = axeDetailsRepository.findAll();
        List<AxePossibleValues> axePossibleValuesList = axePossibleValuesRepository.findAll();
        new ModelService(axePossibleValuesRepository).buildModele(modeleList, axeDetailsList, axePossibleValuesList);
        apiResponse.addData("marques", marques);
        apiResponse.addData("models", modeleList);
        return apiResponse;
    }
}
