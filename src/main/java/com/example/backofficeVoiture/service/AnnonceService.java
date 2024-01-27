package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.*;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.model.AnnonceDTO;
import com.example.backofficeVoiture.model.AnnonceUpdateDTO;
import com.example.backofficeVoiture.repos.*;
import com.example.backofficeVoiture.response.AnnonceFormData;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public ApiResponse getPendingAnnonce(String etat){
        ApiResponse apiResponse = new ApiResponse();
        List<Annonce> annonces =  annonceRepository.findAnnonceByEtat(Integer.valueOf(etat));
        for (Annonce annonce: annonces){
            for (DetailsModele detailsModele : annonce.getAnnonceDetailsModeles()){
                //System.out.println(detailsModele.getValue());
                AxePossibleValues axePossibleValues = axePossibleValuesRepository.getReferenceById(detailsModele.getValue());
                try{
                    detailsModele.setAxePossibleValues(axePossibleValues);
                }catch (Exception e){
                    detailsModele.setAxePossibleValues(new AxePossibleValues());
                }
            }
        }
        apiResponse.addData("pending",annonces);
        return apiResponse;
    }

    public ApiResponse obetnirAnnonces(String token){
        ApiResponse apiResponse = new ApiResponse();
        try {
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
            List<Annonce> annonces = annonceRepository.findAnnonceByUtilisateur(utilisateur);
            for (Annonce annonce: annonces){
                for (DetailsModele detailsModele : annonce.getAnnonceDetailsModeles()){
                  //  System.out.println(detailsModele.getValue());
                    AxePossibleValues axePossibleValues = axePossibleValuesRepository.getReferenceById(detailsModele.getValue());
                    try{
                        detailsModele.setAxePossibleValues(axePossibleValues);
                    }catch (Exception e){
                        detailsModele.setAxePossibleValues(new AxePossibleValues());
                    }
                }
            }
            apiResponse.addData("annonces", annonces);
            apiResponse.setMessage("success");
        } catch (Exception e){
            apiResponse.setMessage("something whent wrong");
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse insererAnnonce(AnnonceForm annonceForm, String token){
        System.out.println("insertion d'annonce");
        ApiResponse apiResponse = new ApiResponse();
        try{
        //    annonceForm.controlData();
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
            apiResponse.setMessage("success");
        }
        catch (Exception e){
            System.out.println(e);
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse annonceFormData(String token) throws AccessDeniedException {
        ApiResponse apiResponse = new ApiResponse();
        try{
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateurService.getUserById(utilisateur.getIdUtilisateur());
            List<Marque> marques = marqueRepository.findAll();
            List<Modele> modeleList = modeleRepository.findAll();
            List<AxeDetails> axeDetailsList = axeDetailsRepository.findAll();
            new ModelService(axePossibleValuesRepository).buildModele(modeleList, axeDetailsList);
            apiResponse.addData("marques", marques);
            apiResponse.addData("models", modeleList);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse updateAnnonce(AnnonceUpdateDTO annonceUpdateDTO, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
            Annonce annonce = annonceRepository.findAnnonceByIdAnnonceAndUtilisateur(annonceUpdateDTO.getIdAnnonce(), utilisateur);
            annonce.setEtat(annonceUpdateDTO.getEtat());
            annonceRepository.save(annonce);
            apiResponse.setMessage("success");
        }
        catch (Exception e){
            apiResponse.setMessage("something went wrong");
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }

    public AnnonceService(final AnnonceRepository annonceRepository,
                          final UtilisateurRepository utilisateurRepository) {
        this.annonceRepository = annonceRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<AnnonceDTO> findAll(String token) throws AccessDeniedException {
        Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
        utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
        final List<Annonce> annonces = annonceRepository.findAll(Sort.by("idAnnonce"));
        return annonces.stream()
                .map(annonce -> mapToDTO(annonce, new AnnonceDTO()))
                .toList();
    }

    public AnnonceDTO get(final String idAnnonce, String token) throws Exception {
        Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
        utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
        return annonceRepository.findById(idAnnonce)
                .map(annonce -> mapToDTO(annonce, new AnnonceDTO()))
                .orElseThrow(Exception::new);
    }

    public String create(final AnnonceDTO annonceDTO, String token) throws Exception {
        Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
        utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
        final Annonce annonce = new Annonce();
        mapToEntity(annonceDTO, annonce);
        annonce.setIdAnnonce(annonceDTO.getIdAnnonce());
        return annonceRepository.save(annonce).getIdAnnonce();
    }

    public void update(final String idAnnonce, final AnnonceDTO annonceDTO, String token) throws Exception {
        Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
        utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
        final Annonce annonce = annonceRepository.findById(idAnnonce)
                .orElseThrow(Exception::new);
        mapToEntity(annonceDTO, annonce);
        annonceRepository.save(annonce);
    }

    public void delete(final String idAnnonce, String token) throws AccessDeniedException {
        Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
        utilisateur = utilisateurService.getUserById(utilisateur.getIdUtilisateur());
        annonceRepository.deleteById(idAnnonce);
    }

    private AnnonceDTO mapToDTO(final Annonce annonce, final AnnonceDTO annonceDTO) {
        annonceDTO.setIdAnnonce(annonce.getIdAnnonce());
        annonceDTO.setAnnee(annonce.getAnnee());
        annonceDTO.setKilometrage(annonce.getKilometrage());
        annonceDTO.setDateAnnonce(annonce.getDateAnnonce());
        annonceDTO.setDescription(annonce.getDescription());
        annonceDTO.setEtat(annonce.getEtat());
        annonceDTO.setUtilisateur(annonce.getUtilisateur() == null ? null : annonce.getUtilisateur().getIdUtilisateur());
        annonceDTO.setHistoriqueModificationAnnonceUtilisateurs(annonce.getHistoriqueModificationAnnonceUtilisateurs().stream()
                .map(utilisateur -> utilisateur.getIdUtilisateur())
                .toList());
        return annonceDTO;
    }

    private Annonce mapToEntity(final AnnonceDTO annonceDTO, final Annonce annonce) throws Exception {
        annonce.setAnnee(annonceDTO.getAnnee());
        annonce.setKilometrage(annonceDTO.getKilometrage());
        annonce.setDateAnnonce(annonceDTO.getDateAnnonce());
        annonce.setDescription(annonceDTO.getDescription());
        annonce.setEtat(annonceDTO.getEtat());
        final Utilisateur utilisateur = annonceDTO.getUtilisateur() == null ? null : utilisateurRepository.findById(annonceDTO.getUtilisateur())
                .orElseThrow(() -> new Exception("utilisateur not found"));
        annonce.setUtilisateur(utilisateur);
        final List<Utilisateur> historiqueModificationAnnonceUtilisateurs = utilisateurRepository.findAllById(
                annonceDTO.getHistoriqueModificationAnnonceUtilisateurs() == null ? Collections.emptyList() : annonceDTO.getHistoriqueModificationAnnonceUtilisateurs());
        if (historiqueModificationAnnonceUtilisateurs.size() != (annonceDTO.getHistoriqueModificationAnnonceUtilisateurs() == null ? 0 : annonceDTO.getHistoriqueModificationAnnonceUtilisateurs().size())) {
            throw new Exception("one of historiqueModificationAnnonceUtilisateurs not found");
        }
        annonce.setHistoriqueModificationAnnonceUtilisateurs(historiqueModificationAnnonceUtilisateurs.stream().collect(Collectors.toSet()));
        return annonce;
    }

    public boolean idAnnonceExists(final String idAnnonce) {
        return annonceRepository.existsByIdAnnonceIgnoreCase(idAnnonce);
    }

}
