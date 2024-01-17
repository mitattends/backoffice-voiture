package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Utilisateur;
import com.example.backofficeVoiture.form.UtilisateurLoginForm;
import com.example.backofficeVoiture.form.UtilisateurSigninForm;
import com.example.backofficeVoiture.service.UtilisateurService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentification")
public class AuthentificationController {
    @Autowired
    UtilisateurService utilisateurService;
    @PostMapping("/login")
    public ApiResponse login(@RequestBody UtilisateurLoginForm utilisateurLoginForm){
        return utilisateurService.login(utilisateurLoginForm);
    }
    @PostMapping("/signin")
    public ApiResponse signin(@RequestBody UtilisateurSigninForm utilisateurSigninForm){
        return utilisateurService.signin(utilisateurSigninForm);
    }
    @PostMapping("/token")
    public ApiResponse validateToken(@RequestHeader("Authorization") String token){
        return utilisateurService.verifyToken(token);
    }
}
