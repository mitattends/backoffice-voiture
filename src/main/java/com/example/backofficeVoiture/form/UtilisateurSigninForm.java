package com.example.backofficeVoiture.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurSigninForm extends UtilisateurLoginForm{
    String nom;
    String prenom;
    String dateNaissance;
    String validationMotDePasse;

    public void checkPassword() throws Exception {
        System.out.println("1 "+this.password);
        System.out.println("2 "+this.validationMotDePasse);
        if(!this.password.equals(this.validationMotDePasse)) throw new Exception("Les mots de passe ne concorde pas");
    }
}
