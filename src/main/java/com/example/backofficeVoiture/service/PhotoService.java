package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Annonce;
import com.example.backofficeVoiture.domain.Photo;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.repos.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public void insertMultiplePhoto(AnnonceForm annonceForm, Annonce annoce){
        for (String photo: annonceForm.getImage()){
            Photo photo1 = new Photo();
            photo1.setText(photo);
            photo1.setAnnonce(annoce);
            photoRepository.save(photo1);
        }
    }
}
