package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Annonce;
import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.domain.DetailsModele;
import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.form.AxeValues;
import com.example.backofficeVoiture.model.DetailsModeleDTO;
import com.example.backofficeVoiture.repos.AnnonceRepository;
import com.example.backofficeVoiture.repos.AxeDetailsRepository;
import com.example.backofficeVoiture.repos.DetailsModeleRepository;
import com.example.backofficeVoiture.repos.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsModelService {
    @Autowired
    DetailsModeleRepository detailsModeleRepository;
    @Autowired
    AxeDetailsRepository axeDetailsRepository;
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    ModeleRepository modeleRepository;
    public void insert(AnnonceForm annonceForm, Annonce annonce){
        try{
            for(AxeValues axeValues : annonceForm.getAxeValues()){
                AxeDetails axeDetails = axeDetailsRepository.findAxeDetailsByIdAxe(axeValues.getIndex());
                DetailsModele detailsModele = new DetailsModele();
                detailsModele.setValue(axeValues.getValue());
                detailsModele.setAxe(axeDetails);
                detailsModele.setIdModel(annonceForm.getSelectedModel());
                detailsModele.setAnnonce(annonce);
                Long id = detailsModeleRepository.getNextSequenceValue();
                detailsModele.setIdDetailsModele(id);
                System.out.println("id "+detailsModele.getIdDetailsModele());
                detailsModeleRepository.save(detailsModele);
            }
        }catch (Exception e) {
            throw e;
        }
    }

    public List<DetailsModeleDTO> findAll() {
        final List<DetailsModele> detailsModeles = detailsModeleRepository.findAll(Sort.by("idDetailsModel"));
        return detailsModeles.stream()
                .map(detailsModele -> mapToDTO(detailsModele, new DetailsModeleDTO()))
                .toList();
    }

    public DetailsModeleDTO get(final String idDetailsModel) throws Exception {
        return detailsModeleRepository.findById(idDetailsModel)
                .map(detailsModele -> mapToDTO(detailsModele, new DetailsModeleDTO()))
                .orElseThrow(Exception::new);
    }

    public String create(final DetailsModeleDTO detailsModeleDTO) throws Exception {
        final DetailsModele detailsModele = new DetailsModele();
        mapToEntity(detailsModeleDTO, detailsModele);
        return detailsModeleRepository.save(detailsModele).getIdDetailsModele();
    }

    public void update(final String idDetailsModel, final DetailsModeleDTO detailsModeleDTO) throws Exception {
        final DetailsModele detailsModele = detailsModeleRepository.findById(idDetailsModel)
                .orElseThrow(Exception::new);
        mapToEntity(detailsModeleDTO, detailsModele);
        detailsModeleRepository.save(detailsModele);
    }

    public void delete(final String idDetailsModel) {
        detailsModeleRepository.deleteById(idDetailsModel);
    }

    private DetailsModeleDTO mapToDTO(final DetailsModele detailsModele,
                                      final DetailsModeleDTO detailsModeleDTO) {
        detailsModeleDTO.setIdDetailsModel(detailsModele.getIdDetailsModele());
        detailsModeleDTO.setValue(detailsModele.getValue());
        detailsModeleDTO.setIdModele(detailsModele.getIdModel() == null ? null : detailsModele.getIdModel());
        detailsModeleDTO.setAnnonce(detailsModele.getAnnonce() == null ? null : detailsModele.getAnnonce().getIdAnnonce());
        detailsModeleDTO.setAxe(detailsModele.getAxe() == null ? null : detailsModele.getAxe().getIdAxe());
        return detailsModeleDTO;
    }

    private DetailsModele mapToEntity(final DetailsModeleDTO detailsModeleDTO,
                                      final DetailsModele detailsModele) throws Exception {
        detailsModele.setValue(detailsModeleDTO.getValue());
        final Modele modele = detailsModeleDTO.getIdModele() == null ? null : modeleRepository.findById(detailsModeleDTO.getIdModele())
                .orElseThrow(() -> new Exception("modele not found"));
        detailsModele.setIdModel(modele.getIdModele());
        final Annonce annonce = detailsModeleDTO.getAnnonce() == null ? null : annonceRepository.findById(detailsModeleDTO.getAnnonce())
                .orElseThrow(() -> new Exception("annonce not found"));
        detailsModele.setAnnonce(annonce);
        final AxeDetails axe = detailsModeleDTO.getAxe() == null ? null : axeDetailsRepository.findById(detailsModeleDTO.getAxe())
                .orElseThrow(() -> new Exception("axe not found"));
        detailsModele.setAxe(axe);
        return detailsModele;
    }

}
