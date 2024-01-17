package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.AxePossibleValues;
import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.repos.AxeDetailsRepository;
import com.example.backofficeVoiture.repos.AxePossibleValuesRepository;
import com.example.backofficeVoiture.repos.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Set;

@Service
public class AxePossibleValuesService {
    @Autowired
    AxePossibleValuesRepository axePossibleValuesRepository;

    @Autowired
    ModeleRepository modeleRepository;

}
