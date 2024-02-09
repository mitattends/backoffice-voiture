package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Utilisateur;
import com.example.backofficeVoiture.form.UtilisateurLoginForm;
import com.example.backofficeVoiture.form.UtilisateurSigninForm;
import com.example.backofficeVoiture.model.UtilisateurDTO;
import com.example.backofficeVoiture.repos.AnnonceRepository;
import com.example.backofficeVoiture.repos.UtilisateurRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    AnnonceRepository annonceRepository;

    public Utilisateur getUserById(String id){
        return utilisateurRepository.findUtilisateurByIdUtilisateur(id);
    }

    public ApiResponse verifyToken(String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
            utilisateur = utilisateurRepository.findUtilisateurByIdUtilisateur(utilisateur.getIdUtilisateur());
            apiResponse.addData("token", token);
            apiResponse.addData("utilisateur", utilisateur);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse login(UtilisateurLoginForm utilisateurLoginForm){
        ApiResponse apiResponse = new ApiResponse();
        try{
            Utilisateur utilisateur = utilisateurRepository.findUtilisateurByMotDePasseAndEmail(utilisateurLoginForm.getPassword(), utilisateurLoginForm.getEmail());
            if(utilisateur == null) throw new Exception("Authentification failed.");
            String token = new JwtUtil().userToken(utilisateur);

            System.out.println("token provide "+token);
            apiResponse.addData("utilisateur", utilisateur);
            apiResponse.addData("token", token);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
            apiResponse.setMessage("Wrong password or email");

        }
        return apiResponse;
    }

    public ApiResponse signin(UtilisateurSigninForm utilisateurSigninForm) {
        ApiResponse apiResponse = new ApiResponse();
        try{
            //utilisateurSigninForm.checkPassword();
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(utilisateurSigninForm.getNom());
            utilisateur.setPrenom(utilisateurSigninForm.getPrenom());
            utilisateur.setSexe(Integer.valueOf(utilisateurSigninForm.getSexe()));
            System.out.println(utilisateurSigninForm.getDateNaissance());
          //  utilisateur.setDateNaissance(utilisateurSigninForm.getDateNaissance());
            utilisateur.setEmail(utilisateurSigninForm.getEmail());
            utilisateur.setMotDePasse(utilisateurSigninForm.getValidationMotDePasse());
            utilisateur.setIdUtilisateur(utilisateurRepository.getNextSequenceValue());
            utilisateurRepository.save(utilisateur);
            apiResponse.setMessage("succes");
            String token = new JwtUtil().userToken(utilisateur);
            apiResponse.addData("token", token);
            apiResponse.addData("utilisateur", utilisateur);
        } catch (Exception e){
            System.out.println(e);
             apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }

    public List<UtilisateurDTO> findAll() {
        final List<Utilisateur> utilisateurs = utilisateurRepository.findAll(Sort.by("idUtilisateur"));
        return utilisateurs.stream()
                .map(utilisateur -> mapToDTO(utilisateur, new UtilisateurDTO()))
                .toList();
    }

    public UtilisateurDTO get(final String idUtilisateur) throws Exception {
        return utilisateurRepository.findById(idUtilisateur)
                .map(utilisateur -> mapToDTO(utilisateur, new UtilisateurDTO()))
                .orElseThrow(Exception::new);
    }

    public String create(final UtilisateurDTO utilisateurDTO) {
        final Utilisateur utilisateur = new Utilisateur();
        mapToEntity(utilisateurDTO, utilisateur);
        utilisateur.setIdUtilisateur(utilisateurDTO.getIdUtilisateur());
        return utilisateurRepository.save(utilisateur).getIdUtilisateur();
    }

    public void update(final String idUtilisateur, final UtilisateurDTO utilisateurDTO) throws Exception {
        final Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(Exception::new);
        mapToEntity(utilisateurDTO, utilisateur);
        utilisateurRepository.save(utilisateur);
    }

    public void delete(final String idUtilisateur) throws Exception {
        final Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(Exception::new);
        // remove many-to-many relations at owning side
        annonceRepository.findAllByHistoriqueModificationAnnonceUtilisateurs(utilisateur)
                .forEach(annonce -> annonce.getHistoriqueModificationAnnonceUtilisateurs().remove(utilisateur));
        utilisateurRepository.delete(utilisateur);
    }

    private UtilisateurDTO mapToDTO(final Utilisateur utilisateur,
                                    final UtilisateurDTO utilisateurDTO) {
        utilisateurDTO.setIdUtilisateur(utilisateur.getIdUtilisateur());
        utilisateurDTO.setNom(utilisateur.getNom());
        utilisateurDTO.setPrenom(utilisateur.getPrenom());
        utilisateurDTO.setDateNaissance(utilisateur.getDateNaissance());
        utilisateurDTO.setEmail(utilisateur.getEmail());
        utilisateurDTO.setMotDePasse(utilisateur.getMotDePasse());
        return utilisateurDTO;
    }

    private Utilisateur mapToEntity(final UtilisateurDTO utilisateurDTO,
                                    final Utilisateur utilisateur) {
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setDateNaissance(utilisateurDTO.getDateNaissance());
        utilisateur.setEmail(utilisateurDTO.getEmail());
        utilisateur.setMotDePasse(utilisateurDTO.getMotDePasse());
        return utilisateur;
    }

    public boolean idUtilisateurExists(final String idUtilisateur) {
        return utilisateurRepository.existsByIdUtilisateurIgnoreCase(idUtilisateur);
    }
}
