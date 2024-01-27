package com.example.backofficeVoiture.service;

import java.util.List;

import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.domain.AxePossibleValues;
import com.example.backofficeVoiture.domain.AxeValues;
import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.model.AxePossibleValuesDTO;
import com.example.backofficeVoiture.model.AxeValuesDTO;
import com.example.backofficeVoiture.model.ModeleDTO;
import com.example.backofficeVoiture.repos.AxeDetailsRepository;
import com.example.backofficeVoiture.repos.AxePossibleValuesRepository;
import com.example.backofficeVoiture.repos.AxeValuesRepository;
import com.example.backofficeVoiture.repos.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AxePossibleValuesService {
    @Autowired
    private final AxePossibleValuesRepository axePossibleValuesRepository;
    @Autowired
    private final ModeleRepository modeleRepository;
    @Autowired
    private final AxeDetailsRepository axeDetailsRepository;

    @Autowired
    AxeValuesRepository axeValuesRepository;

    public void insertAxePossibleValue(ModeleDTO modeleDTO){
        List<AxeValuesDTO> axes = modeleDTO.getAxes();
        for (AxeValuesDTO axe: axes){
            for(String possibleValue: axe.getAxeValue()){
                AxeValues valeur = axeValuesRepository.findAxeValuesByIdValue(Integer.valueOf(possibleValue));
                AxePossibleValues axePossibleValues = new AxePossibleValues();
                axePossibleValues.setIdAxePossibleValues(axePossibleValuesRepository.getNextSequenceValue());
                axePossibleValues.setModele(modeleRepository.getReferenceById(modeleDTO.getIdModele()));
                axePossibleValues.setAxe(axeDetailsRepository.getReferenceById(axe.getIdAxe()));
                axePossibleValues.setValue(valeur.getLabel());
                axePossibleValues.setValeurNumerique(1);
                axePossibleValues.setIdValue(valeur.getIdValue());
                axePossibleValuesRepository.save(axePossibleValues);
            }
        }
    }

    public AxePossibleValuesService(AxePossibleValuesRepository axePossibleValuesRepository, ModeleRepository modeleRepository, AxeDetailsRepository axeDetailsRepository) {
        this.axePossibleValuesRepository = axePossibleValuesRepository;
        this.modeleRepository = modeleRepository;
        this.axeDetailsRepository = axeDetailsRepository;
    }

    public List<AxePossibleValuesDTO> findAll() {
        final List<AxePossibleValues> axePossibleValueses = axePossibleValuesRepository.findAll(Sort.by("idAxePossibleValues"));
        return axePossibleValueses.stream()
                .map(axePossibleValues -> mapToDTO(axePossibleValues, new AxePossibleValuesDTO()))
                .toList();
    }

    public AxePossibleValuesDTO get(final String idAxePossibleValues) throws Exception {
        return axePossibleValuesRepository.findById(idAxePossibleValues)
                .map(axePossibleValues -> mapToDTO(axePossibleValues, new AxePossibleValuesDTO()))
                .orElseThrow(Exception::new);
    }

    public String create(final AxePossibleValuesDTO axePossibleValuesDTO) throws Exception {
        final AxePossibleValues axePossibleValues = new AxePossibleValues();
        mapToEntity(axePossibleValuesDTO, axePossibleValues);
        axePossibleValues.setIdAxePossibleValues(axePossibleValuesDTO.getIdAxePossibleValues());
        return axePossibleValuesRepository.save(axePossibleValues).getIdAxePossibleValues();
    }

    public void update(final String idAxePossibleValues,
                       final AxePossibleValuesDTO axePossibleValuesDTO) throws Exception {
        final AxePossibleValues axePossibleValues = axePossibleValuesRepository.findById(idAxePossibleValues)
                .orElseThrow(Exception::new);
        mapToEntity(axePossibleValuesDTO, axePossibleValues);
        axePossibleValuesRepository.save(axePossibleValues);
    }

    public void delete(final String idAxePossibleValues) {
        axePossibleValuesRepository.deleteById(idAxePossibleValues);
    }

    private AxePossibleValuesDTO mapToDTO(final AxePossibleValues axePossibleValues,
                                          final AxePossibleValuesDTO axePossibleValuesDTO) {
        axePossibleValuesDTO.setIdAxePossibleValues(axePossibleValues.getIdAxePossibleValues());
        axePossibleValuesDTO.setValue(axePossibleValues.getValue());
        axePossibleValuesDTO.setModele(axePossibleValues.getModele() == null ? null : axePossibleValues.getModele().getIdModele());
        axePossibleValuesDTO.setAxe(axePossibleValues.getAxe() == null ? null : axePossibleValues.getAxe().getIdAxe());
        return axePossibleValuesDTO;
    }

    private AxePossibleValues mapToEntity(final AxePossibleValuesDTO axePossibleValuesDTO,
                                          final AxePossibleValues axePossibleValues) throws Exception {
        axePossibleValues.setValue(axePossibleValuesDTO.getValue());
        final Modele modele = axePossibleValuesDTO.getModele() == null ? null : modeleRepository.findById(axePossibleValuesDTO.getModele())
                .orElseThrow(() -> new Exception("modele not found"));
        axePossibleValues.setModele(modele);
        final AxeDetails axe = axePossibleValuesDTO.getAxe() == null ? null : axeDetailsRepository.findById(axePossibleValuesDTO.getAxe())
                .orElseThrow(() -> new Exception("axe not found"));
        axePossibleValues.setAxe(axe);
        return axePossibleValues;
    }

    public boolean idAxePossibleValuesExists(final String idAxePossibleValues) {
        return axePossibleValuesRepository.existsByIdAxePossibleValuesIgnoreCase(idAxePossibleValues);
    }

}

