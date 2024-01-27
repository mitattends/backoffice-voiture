package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.service.AnnonceService;
import com.example.backofficeVoiture.service.StatistiqueService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;

@RestController
@RequestMapping("/statistiques")
public class StatistiqueController {
    @Autowired
    StatistiqueService statistiqueService;

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public ApiResponse getStatByYear(@RequestHeader("Authorization") String token){
        // Get the current year
        int currentYear = Year.now().getValue();
        return statistiqueService.getStatAnnonceByYear(String.valueOf(currentYear), token);
    }

    @GetMapping("/{year}")
    @CrossOrigin(origins = "*")
    public ApiResponse getStatByYear(@PathVariable String year, @RequestHeader("Authorization") String token){
        return statistiqueService.getStatAnnonceByYear(year, token);
    }
    @GetMapping("/{year}/marque")
    @CrossOrigin(origins = "*")
    public ApiResponse getStatMarqueByYear(@PathVariable String year, @RequestHeader("Authorization") String token){
        return statistiqueService.getStatNumberMarqueByYear(year, token);
    }
    @GetMapping("/{year}/modele")
    @CrossOrigin(origins = "*")
    public ApiResponse getStatModeleByYear(@PathVariable String year, @RequestHeader("Authorization") String token){
        return statistiqueService.getStatNumberModeleByYear(year, token);
    }

    @GetMapping("//marque")
    @CrossOrigin(origins = "*")
    public ApiResponse getStatMarqueByYear2(@RequestHeader("Authorization") String token){
        int currentYear = Year.now().getValue();
        return statistiqueService.getStatNumberMarqueByYear(currentYear+"", token);
    }
    @GetMapping("//modele")
    @CrossOrigin(origins = "*")
    public ApiResponse getStatModeleByYear2(@RequestHeader("Authorization") String token){
        int currentYear = Year.now().getValue();
        return statistiqueService.getStatNumberModeleByYear(currentYear+"", token);
    }
}
