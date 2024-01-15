package com.example.backofficeVoiture.historiqueModificationAnnonce;

import com.example.backofficeVoiture.utilisateur.Utilisateur;
import com.example.backofficeVoiture.annonce.Annonce;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "historique_modification_annonce", schema = "public", catalog = "postgres")
public class HistoriqueModificationAnnonce {
    private String idAnnonce;
    private String idUtilisateur;
    private Annonce annonceByIdAnnonce;
    private Utilisateur utilisateurByIdUtilisateur;
    private Long id;

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriqueModificationAnnonce that = (HistoriqueModificationAnnonce) o;
        return Objects.equals(idAnnonce, that.idAnnonce) && Objects.equals(idUtilisateur, that.idUtilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, idUtilisateur);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_annonce", referencedColumnName = "id_annonce")
    public Annonce getAnnonceByIdAnnonce() {
        return annonceByIdAnnonce;
    }

    public void setAnnonceByIdAnnonce(Annonce annonceByIdAnnonce) {
        this.annonceByIdAnnonce = annonceByIdAnnonce;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    public Utilisateur getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(Utilisateur utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
