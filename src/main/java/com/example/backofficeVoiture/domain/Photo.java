package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "photo")
public class Photo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_photo")
    private int idPhoto;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "id_annonce")
    private String idAnnonce;

    public Photo(int idPhoto, String text, String idAnnonce) {
        this.setIdPhoto(idPhoto);
        setText(text);
        setIdAnnonce(idAnnonce);
    }

    public Photo() {

    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return idPhoto == photo.idPhoto && Objects.equals(text, photo.text) && Objects.equals(idAnnonce, photo.idAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPhoto, text, idAnnonce);
    }
}
