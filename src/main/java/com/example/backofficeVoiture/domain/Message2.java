package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Message2 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_message2")
    private int idMessage2;
    @Basic
    @Column(name = "id_discussion")
    private Integer idDiscussion;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "date_envoie")
    private Timestamp dateEnvoie;
    @Basic
    @Column(name = "date_reception")
    private Timestamp dateReception;
    @Basic
    @Column(name = "date_vu")
    private Timestamp dateVu;
    @Column(name = "id_sender")
    String idSender;
    @Column(name = "id_receiver")
    String idReceiver;
    public int getIdMessage2() {
        return idMessage2;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public String getIdReceiver() {
        return idReceiver;
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdMessage2(int idMessage2) {
        this.idMessage2 = idMessage2;
    }

    public Integer getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Integer idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Timestamp dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Timestamp getDateReception() {
        return dateReception;
    }

    public void setDateReception(Timestamp dateReception) {
        this.dateReception = dateReception;
    }

    public Timestamp getDateVu() {
        return dateVu;
    }

    public void setDateVu(Timestamp dateVu) {
        this.dateVu = dateVu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message2 message2 = (Message2) o;
        return idMessage2 == message2.idMessage2 && Objects.equals(idDiscussion, message2.idDiscussion) && Objects.equals(message, message2.message) && Objects.equals(dateEnvoie, message2.dateEnvoie) && Objects.equals(dateReception, message2.dateReception) && Objects.equals(dateVu, message2.dateVu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage2, idDiscussion, message, dateEnvoie, dateReception, dateVu);
    }
}
