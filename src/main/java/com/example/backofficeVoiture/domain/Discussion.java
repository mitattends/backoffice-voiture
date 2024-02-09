package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Discussion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_discussion")
    private int idDiscussion;
    @Basic
    @Column(name = "id_annonce")
    private String idAnnonce;
    @Basic
    @Column(name = "date_discussion")
    private Timestamp dateDiscussion;
    @Basic
    @Column(name = "lu")
    private Boolean lu;
    @Basic
    @Column(name = "id_sender")
    private String idSender;
    @Basic
    @Column(name = "id_receiver")
    private String idReceiver;
    @Transient
    boolean vue;

    @Transient
    String nomSender;
    @Transient
    java.util.List<Message2> message2List;

    @Transient
    Integer nombreMessage;

    public void setNomSender(String nomSender) {
        this.nomSender = nomSender;
    }


    public void setNombreMessage(Integer nombreMessage) {
        this.nombreMessage = nombreMessage;
    }

    public String getNomSender() {
        return nomSender;
    }

    public void setNombreMessage() {
        Integer n = 0;
        for (Message2 m : message2List) {
            if(m.getDateReception() == null){
                n += 1;
            }
        }
        nombreMessage = n;
    }

    public Integer getNombreMessage() {
        return nombreMessage;
    }

    public List<Message2> getMessage2List() {
        return message2List;
    }

    public void setMessage2List(List<Message2> message2List) {
        this.message2List = message2List;
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }

    public int getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(int idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Timestamp getDateDiscussion() {
        return dateDiscussion;
    }

    public void setDateDiscussion(Timestamp dateDiscussion) {
        this.dateDiscussion = dateDiscussion;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discussion that = (Discussion) o;
        return idDiscussion == that.idDiscussion && Objects.equals(idAnnonce, that.idAnnonce) && Objects.equals(dateDiscussion, that.dateDiscussion) && Objects.equals(lu, that.lu) && Objects.equals(idSender, that.idSender) && Objects.equals(idReceiver, that.idReceiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiscussion, idAnnonce, dateDiscussion, lu, idSender, idReceiver);
    }
}
