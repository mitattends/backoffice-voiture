package com.example.backofficeVoiture.service;

import com.example.backofficeVoiture.domain.Photo;
import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.repos.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public void insertMultiplePhoto(AnnonceForm annonceForm, String idAnnonce){
       // String insertSValue = "";
        for (String photo: annonceForm.getImage()){
            Photo photo1 = new Photo();
            photo1.setText(photo);
            photo1.setIdAnnonce(idAnnonce);
            photoRepository.save(photo1);
        //    insertSValue += "('"+photo+"','"+idAnnonce+"'),";
        }

        //System.out.println(insertSValue.substring(0, insertSValue.length() - 1));
        //photoRepository.insertMultiplePhoto(insertSValue.substring(0, insertSValue.length() - 1));
    }
}
