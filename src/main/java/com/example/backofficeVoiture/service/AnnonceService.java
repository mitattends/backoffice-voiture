package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.*;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.repos.*;
import com.example.backofficeVoiture.response.AnnonceFormData;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
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

    public ApiResponse obetnirAnnonces(String token){
        ApiResponse apiResponse = new ApiResponse();
        try {
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
            List<Annonce> annonces = annonceRepository.findAnnonceByUtilisateur(utilisateur);
            apiResponse.addData("annonces", annonces);
            apiResponse.setMessage("success");
        } catch (Exception e){
            apiResponse.setMessage("something whent wrong");
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse insererAnnonce(AnnonceForm annonceForm, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            annonceForm.controlData();
            Annonce annonce = new Annonce();
            annonce.setIdAnnonce(annonceRepository.getNextSequenceValue());
            annonce.setAnnee(annonceForm.getAnnee());
            annonce.setKilometrage(annonceForm.getKilometrage());
            annonce.setDescription(annonceForm.getDescription());
            annonce.setEtat(10);
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
            annonce.setUtilisateur(utilisateur);
            annonceRepository.save(annonce);
            photoService.insertMultiplePhoto(annonceForm, annonce);
            detailsModelService.insert(annonceForm, annonce);
            annonceRepository.flush();
            apiResponse.setMessage("success");
        }
        catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse annonceFormData(){
        ApiResponse apiResponse = new ApiResponse();
        List<Marque> marques = marqueRepository.findAll();
        List<Modele> modeleList = modeleRepository.findAll();
        List<AxeDetails> axeDetailsList = axeDetailsRepository.findAll();
        new ModelService(axePossibleValuesRepository).buildModele(modeleList, axeDetailsList);
        apiResponse.addData("marques", marques);
        apiResponse.addData("models", modeleList);
        return apiResponse;
    }
    public ApiResponse updateAnnonce(String idAnnonce, String etat, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
            Annonce annonce = annonceRepository.findAnnonceByIdAnnonceAndUtilisateur(idAnnonce, utilisateur);
            annonce.setEtat(etat);
            annonceRepository.save(annonce);
            apiResponse.setMessage("success");
        }
        catch (Exception e){
            apiResponse.setMessage("something went wrong");
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
}
