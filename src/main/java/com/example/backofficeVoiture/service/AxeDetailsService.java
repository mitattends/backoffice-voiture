package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.AxeDetails;
import com.example.backofficeVoiture.model.AxeDetailsDTO;
import com.example.backofficeVoiture.repos.AxeDetailsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AxeDetailsService {

    private final AxeDetailsRepository axeDetailsRepository;

    public AxeDetailsService(final AxeDetailsRepository axeDetailsRepository) {
        this.axeDetailsRepository = axeDetailsRepository;
    }

    public List<AxeDetailsDTO> findAll() {
        final List<AxeDetails> axeDetailses = axeDetailsRepository.findAll(Sort.by("idAxe"));
        return axeDetailses.stream()
                .map(axeDetails -> mapToDTO(axeDetails, new AxeDetailsDTO()))
                .toList();
    }

    public AxeDetailsDTO get(final String idAxe) throws Exception {
        return axeDetailsRepository.findById(idAxe)
                .map(axeDetails -> mapToDTO(axeDetails, new AxeDetailsDTO()))
                .orElseThrow(Exception::new);
    }

    public String create(final AxeDetailsDTO axeDetailsDTO) {
        final AxeDetails axeDetails = new AxeDetails();
        mapToEntity(axeDetailsDTO, axeDetails);
        axeDetails.setIdAxe(axeDetailsDTO.getIdAxe());
        return axeDetailsRepository.save(axeDetails).getIdAxe();
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
