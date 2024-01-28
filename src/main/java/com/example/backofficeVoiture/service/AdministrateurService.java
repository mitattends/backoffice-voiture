package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Administrateur;
import com.example.backofficeVoiture.domain.VNombreAnnonceParMoisParAnnee;
import com.example.backofficeVoiture.model.AdministrateurDTO;
import com.example.backofficeVoiture.repos.AdministrateurRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurService {
    @Autowired
    AdministrateurRepository administrateurRepository;
    public ApiResponse insert(AdministrateurDTO administrateurDTO, String tokenS){
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(tokenS);
            Administrateur administrateur = administrateurDTO.getAdministrateur();
            administrateur.setIdAdministrateur(administrateurRepository.getNextSequenceValue());
            String token = new JwtUtil().generate(administrateur);
            administrateurRepository.save(administrateur);
            apiResponse.setMessage("success");
            apiResponse.addData("token", token);
            apiResponse.addData("user", administrateur);
        }catch (Exception e){
            apiResponse.setMessage("Something went wrong");
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse verify(AdministrateurDTO administrateurDTO){
        ApiResponse apiResponse = new ApiResponse();
        try{
            Administrateur administrateur = administrateurDTO.getAdministrateur();
            System.out.println(administrateurDTO.getEmail());
            System.out.println(administrateurDTO.getMotDePasse());
            administrateur = administrateurRepository.findAdministrateurByEmailAndMotDePasse(administrateurDTO.getEmail(), administrateurDTO.getMotDePasse());
            if(administrateur == null) throw new Exception("Login invalide");
            administrateur.setIdAdministrateur(administrateurRepository.getNextSequenceValue());
            String token = new JwtUtil().generate(administrateur);
            apiResponse.setMessage("success");
            apiResponse.addData("token", token);
            apiResponse.addData("user", administrateur);
        }catch (Exception e){
            apiResponse.setMessage("error");
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }
}
