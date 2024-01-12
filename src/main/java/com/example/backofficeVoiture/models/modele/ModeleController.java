package com.example.backofficeVoiture.models.modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/modele")
public class ModeleController {
    @Autowired
    ModeleRepository modeleRepository;

    //ajouter l'objet Marque
    public @ResponseBody String addNewModele(@RequestParam String nom){
        Modele modele = new Modele();
        modele.setNom(nom);
        modeleRepository.save(modele);
        return "saved";
    }

    public @ResponseBody Iterable<Modele> getAll(){
        return modeleRepository.findAll();
    }
}
