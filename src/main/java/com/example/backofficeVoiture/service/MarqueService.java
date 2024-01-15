package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.repos.MarqueRepository;
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
}
