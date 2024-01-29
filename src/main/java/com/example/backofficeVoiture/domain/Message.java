package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Message {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_message")
    private int idMessage;
    @Basic
    @Column(name = "id_sender")
    private String idSender;
    @Basic
    @Column(name = "id_receiver")
    private String idReceiver;
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
    @Column(name = "date_vue")
    private Timestamp dateVue;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
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

    public Timestamp getDateVue() {
        return dateVue;
    }

    public void setDateVue(Timestamp dateVue) {
        this.dateVue = dateVue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return idMessage == message1.idMessage && Objects.equals(idSender, message1.idSender) && Objects.equals(idReceiver, message1.idReceiver) && Objects.equals(message, message1.message) && Objects.equals(dateEnvoie, message1.dateEnvoie) && Objects.equals(dateReception, message1.dateReception) && Objects.equals(dateVue, message1.dateVue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage, idSender, idReceiver, message, dateEnvoie, dateReception, dateVue);
    }

    public void setDateEnvoie(String dateEnvoie) {
        if(dateEnvoie == null | dateEnvoie == ""){
            this.setDateEnvoie(Timestamp.valueOf(LocalDateTime.now()));
        }else {
            dateEnvoie = dateEnvoie.replace("T", " ").concat(":00");
            this.setDateEnvoie(Timestamp.valueOf(dateEnvoie));
        }
    }

    public void setDateVue(String dateVue) {
        if (dateVue == null | dateVue == ""){}
        else {
            dateVue = dateVue.replace("T", " ").concat(":00");
            this.setDateVue(Timestamp.valueOf(dateVue));
        }
    }

    public void setDateReception(String dateReception) {
        if(dateReception == null | dateReception == "") {}
        else{
            dateReception = dateReception.replace("T", " ").concat(":00");
            this.setDateReception(Timestamp.valueOf(dateReception));
        }
    }
}
