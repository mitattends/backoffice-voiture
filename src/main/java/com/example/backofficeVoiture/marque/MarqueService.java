package com.example.backofficeVoiture.marque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarqueService {
    @Autowired
    MarqueRepository marqueRepository;

    public void insert(Marque marque){
        this.marqueRepository.save(marque);
    }
}
