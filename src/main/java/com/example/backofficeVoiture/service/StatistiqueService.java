package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.VNombreVenteModele;
import com.example.backofficeVoiture.repos.VNombreAnnonceParMoisParAnneeRepository;
import com.example.backofficeVoiture.repos.VNombreVenteMarqueRepository;
import com.example.backofficeVoiture.repos.VNombreVenteModeleRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StatistiqueService {

    @Autowired
    VNombreAnnonceParMoisParAnneeRepository vNombreAnnonceParMoisParAnneeRepository;
    @Autowired
    VNombreVenteMarqueRepository vNombreVenteMarqueRepository;

    @Autowired
    VNombreVenteModeleRepository vNombreVenteModeleRepository;
    public ApiResponse getStatNumberModeleByYear(String year, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(token);
            apiResponse.addData("stat", vNombreVenteModeleRepository.getNombreVenteParAnneeParModele(year));
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
            apiResponse.setError(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse getStatNumberMarqueByYear(String year, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(token);
            apiResponse.addData("stat", vNombreVenteMarqueRepository.getNombreVenteParAnneeParMarque(year));
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
            apiResponse.setError(e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse getStatAnnonceByYear(String year, String token){
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(token);
            apiResponse.addData("stat", vNombreAnnonceParMoisParAnneeRepository.nombreAnnonceParMoisParAnnee(year));
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
            apiResponse.setError(e.getMessage());
        }
        return apiResponse;
    }
}
