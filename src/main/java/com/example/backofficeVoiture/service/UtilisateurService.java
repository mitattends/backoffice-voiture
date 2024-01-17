package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Utilisateur;
import com.example.backofficeVoiture.form.UtilisateurLoginForm;
import com.example.backofficeVoiture.form.UtilisateurSigninForm;
import com.example.backofficeVoiture.repos.UtilisateurRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public Utilisateur getUserById(String id){
        return utilisateurRepository.findUtilisateurByIdUtilisateur(id);
    }

    public ApiResponse verifyToken(String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            Claims claims = new JwtUtil().verify(token);
            Utilisateur utilisateur = new JwtUtil().findUserByToken(token);
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
            apiResponse.addData("token", token);
            apiResponse.addData("utilisateur", utilisateur);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
            apiResponse.setMessage("Wrong password or email");
        }
        return apiResponse;
    }

    public ApiResponse signin(UtilisateurSigninForm utilisateurSigninForm){
        ApiResponse apiResponse = new ApiResponse();
        try{
            utilisateurSigninForm.checkPassword();
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(utilisateurSigninForm.getNom());
            utilisateur.setPrenom(utilisateurSigninForm.getPrenom());
            utilisateur.setDateNaissance(utilisateurSigninForm.getDateNaissance());
            utilisateur.setEmail(utilisateurSigninForm.getEmail());
            utilisateur.setMotDePasse(utilisateurSigninForm.getValidationMotDePasse());
            utilisateur.setIdUtilisateur(utilisateurRepository.getNextSequenceValue());
            utilisateurRepository.save(utilisateur);
            apiResponse.setMessage("succes");
            String token = new JwtUtil().userToken(utilisateur);
            apiResponse.addData("token", token);
            apiResponse.addData("utilisateur", utilisateur);
        } catch (Exception e){
          apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
}
