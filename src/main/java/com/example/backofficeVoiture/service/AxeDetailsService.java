package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.domain.AxeValues;
import com.example.backofficeVoiture.model.AxeDetailsDTO;
import com.example.backofficeVoiture.repos.AxeDetailsRepository;
import com.example.backofficeVoiture.repos.AxeValuesRepository;
import com.example.backofficeVoiture.util.ApiResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AxeDetailsService {

    private final AxeDetailsRepository axeDetailsRepository;
    @Autowired
    AxeValuesRepository axeValuesRepository;

    public AxeDetailsService(final AxeDetailsRepository axeDetailsRepository) {
        this.axeDetailsRepository = axeDetailsRepository;
    }

    public List<AxeDetails> findAll() {
        List<AxeDetails> axeDetailses = axeDetailsRepository.findAll(Sort.by("idAxe"));
        for (AxeDetails ax : axeDetailses){
            ax.setAxePossibleValuesList(axeValuesRepository.findAxeValuesByIdAxe(ax.getIdAxe()));
        }
        return axeDetailses;
    }

    public AxeDetailsDTO get(final String idAxe) throws Exception {
        return axeDetailsRepository.findById(idAxe)
                .map(axeDetails -> mapToDTO(axeDetails, new AxeDetailsDTO()))
                .orElseThrow(Exception::new);
    }

    @Transactional
    public String create(final AxeDetailsDTO axeDetailsDTO) {
        final AxeDetails axeDetails = new AxeDetails();
        mapToEntity(axeDetailsDTO, axeDetails);
        axeDetails.setIdAxeDetails(axeDetailsRepository.getNextSequenceValue());
        axeDetailsRepository.save(axeDetails);
        saveAxeValue(axeDetailsDTO.getDetails(), axeDetails.getIdAxe());
        return "succes";
    }

    public void saveAxeValue(String[] details, String idAxe){
        for (String detail : details){
            AxeValues axeValues = new AxeValues();
            axeValues.setLabel(detail);
            axeValues.setIdAxe(idAxe);
            axeValuesRepository.save(axeValues);
        }
    }

    public void update(final String idAxe, final AxeDetailsDTO axeDetailsDTO) throws Exception {
        final AxeDetails axeDetails = axeDetailsRepository.findById(idAxe)
                .orElseThrow(Exception::new);
        mapToEntity(axeDetailsDTO, axeDetails);
        axeDetailsRepository.save(axeDetails);
    }

    public void delete(final String idAxe) {
        axeDetailsRepository.deleteById(idAxe);
    }

    private AxeDetailsDTO mapToDTO(final AxeDetails axeDetails, final AxeDetailsDTO axeDetailsDTO) {
        axeDetailsDTO.setIdAxe(axeDetails.getIdAxe());
        axeDetailsDTO.setNom(axeDetails.getNom());
        return axeDetailsDTO;
    }

    private AxeDetails mapToEntity(final AxeDetailsDTO axeDetailsDTO, final AxeDetails axeDetails) {
        axeDetails.setNom(axeDetailsDTO.getNom());
        return axeDetails;
    }

    public boolean idAxeExists(final String idAxe) {
        return axeDetailsRepository.existsByIdAxeIgnoreCase(idAxe);
    }

}
