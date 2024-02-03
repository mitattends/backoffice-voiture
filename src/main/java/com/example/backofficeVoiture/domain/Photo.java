package com.example.backofficeVoiture.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_annonce")
    @JsonBackReference
    private Annonce annonce;

    @Basic
    @Column(name = "field_bytes")
    byte[] fieldBytes;

    public void setFieldBytes(byte[] fieldBytes) {
        this.fieldBytes = fieldBytes;
    }

    public byte[] getFieldBytes() {
        return fieldBytes;
    }

    public Photo(int idPhoto, String text, Annonce annonce) {
        this.setIdPhoto(idPhoto);
        setText(text);
        setAnnonce(annonce);
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

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Annonce getAnnonce() {
        return annonce;
    }
}
