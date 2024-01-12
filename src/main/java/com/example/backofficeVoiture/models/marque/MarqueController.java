package com.example.backofficeVoiture.models.marque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/marque")
public class MarqueController {
    @Autowired
    MarqueRepository marqueRespRepository;

    //ajouter les objets modeles
    public @ResponseBody String addNewMarque(String nom){
        Marque marque = new Marque();
        marque.setNom(nom);
        marqueRespRepository.save(marque);
        return "saved";
    }

    public @ResponseBody Iterable<Marque> getAll(){
        return marqueRespRepository.findAll();
    }
}
