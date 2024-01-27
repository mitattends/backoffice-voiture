package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.model.MarqueDTO;
import com.example.backofficeVoiture.repos.MarqueRepository;
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

    public String create(final MarqueDTO marqueDTO, String token) throws Exception {
        new JwtUtil().verify(token);
        final Marque marque = new Marque();
        mapToEntity(marqueDTO, marque);
        marque.setIdMarque(marqueRepository.getNextSequenceValue());
        return marqueRepository.save(marque).getIdMarque();
    }

    public void update(final String idMarque, final MarqueDTO marqueDTO) throws Exception {
        final Marque marque = marqueRepository.findById(idMarque)
                .orElseThrow(Exception::new);
        mapToEntity(marqueDTO, marque);
        marqueRepository.save(marque);
    }

    public void delete(final String idMarque) {
        marqueRepository.deleteById(idMarque);
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
