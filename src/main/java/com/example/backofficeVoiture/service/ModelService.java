package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.domain.AxePossibleValues;
import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.model.ModeleDTO;
import com.example.backofficeVoiture.repos.AxePossibleValuesRepository;
import com.example.backofficeVoiture.repos.MarqueRepository;
import com.example.backofficeVoiture.repos.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    AxePossibleValuesRepository axePossibleValuesRepository;

    @Autowired
    ModeleRepository modeleRepository;
    @Autowired
    MarqueRepository marqueRepository;
    @Autowired
    AxePossibleValuesService axePossibleValuesService;
    public ModelService(AxePossibleValuesRepository axePossibleValuesRepository){
        this.axePossibleValuesRepository = axePossibleValuesRepository;
    }
    public void buildModele(List<Modele> modeleList, List<AxeDetails> axeDetailsList){
        for (Modele modele: modeleList) {
            modele.idMarque = modele.getMarque().getIdMarque();
            modele.setAxeDetailsAxeList(axeDetailsList);
            modele.setAxeDetailsListPossibleValues(axePossibleValuesRepository.getAxePossibleValuesByModele(modele));
            modele.rectifyData();
        }
    }

    public List<ModeleDTO> findAll() {
        final List<Modele> modeles = modeleRepository.findAll(Sort.by("idModele"));
        return modeles.stream()
                .map(modele -> mapToDTO(modele, new ModeleDTO()))
                .toList();
    }

    public ModeleDTO get(final String idModele) throws Exception {
        return modeleRepository.findById(idModele)
                .map(modele -> mapToDTO(modele, new ModeleDTO()))
                .orElseThrow(Exception::new);
    }

    public String create(final ModeleDTO modeleDTO) throws Exception {
        final Modele modele = new Modele();
        modele.setNom(modeleDTO.getNom());
        modele.setMarque(marqueRepository.findMarqueByIdMarque(modeleDTO.getMarque()));
        modele.setIdModele(modeleRepository.getNextSequenceValue());

        modeleRepository.save(modele);
        modeleDTO.setIdModele(modele.getIdModele());
        axePossibleValuesService.insertAxePossibleValue(modeleDTO);
        // save the rest
        return "succes";
    }

    public void update(final String idModele, final ModeleDTO modeleDTO) throws Exception {
        final Modele modele = modeleRepository.findById(idModele)
                .orElseThrow(Exception::new);
        mapToEntity(modeleDTO, modele);
        modeleRepository.save(modele);
    }

    public void delete(final String idModele) {
        modeleRepository.deleteById(idModele);
    }

    private ModeleDTO mapToDTO(final Modele modele, final ModeleDTO modeleDTO) {
        modeleDTO.setIdModele(modele.getIdModele());
        modeleDTO.setNom(modele.getNom());
        modeleDTO.setMarque(modele.getMarque() == null ? null : modele.getMarque().getIdMarque());
        return modeleDTO;
    }

    private Modele mapToEntity(final ModeleDTO modeleDTO, final Modele modele) throws Exception {
        modele.setNom(modeleDTO.getNom());
        final Marque marque = marqueRepository.findMarqueByIdMarque(modeleDTO.getMarque());
        modele.setMarque(marque);
        return modele;
    }

    public boolean idModeleExists(final String idModele) {
        return modeleRepository.existsByIdModeleIgnoreCase(idModele);
    }

}
