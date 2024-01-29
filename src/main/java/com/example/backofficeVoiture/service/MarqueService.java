package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.model.MarqueDTO;
import com.example.backofficeVoiture.repos.MarqueRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    MarqueRepository marqueRepository;
    public List<Marque> findAll(){
        return marqueRepository.findAll();
    }

    public MarqueDTO get(final String idMarque) throws Exception {
        return marqueRepository.findById(idMarque)
                .map(marque -> mapToDTO(marque, new MarqueDTO()))
                .orElseThrow(Exception::new);
    }

    public ApiResponse create(final MarqueDTO marqueDTO, String token) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(token);
            final Marque marque = new Marque();
            mapToEntity(marqueDTO, marque);
            marque.setIdMarque(marqueRepository.getNextSequenceValue());
            marqueRepository.saveAndFlush(marque);
            apiResponse.setMessage("Succes");
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
            apiResponse.setError(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse update(final String idMarque, final MarqueDTO marqueDTO, String token) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(token);
            final Marque marque = marqueRepository.findById(idMarque)
                    .orElseThrow(Exception::new);
            mapToEntity(marqueDTO, marque);
            marqueRepository.save(marque);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse delete(final String idMarque, String token) {
        ApiResponse apiResponse = new ApiResponse();
        try{
            new JwtUtil().verify(token);
            marqueRepository.deleteById(idMarque);
        }catch (Exception e){
            apiResponse.addData("error", e.getMessage());
        }
        return apiResponse;
    }

    private MarqueDTO mapToDTO(final Marque marque, final MarqueDTO marqueDTO) {
        marqueDTO.setIdMarque(marque.getIdMarque());
        marqueDTO.setNom(marque.getNom());
        return marqueDTO;
    }

    private Marque mapToEntity(final MarqueDTO marqueDTO, final Marque marque) {
        marque.setNom(marqueDTO.getNom());
        return marque;
    }

    public boolean idMarqueExists(final String idMarque) {
        return marqueRepository.existsByIdMarqueIgnoreCase(idMarque);
    }

}
