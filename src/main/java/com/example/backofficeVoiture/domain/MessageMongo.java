package com.example.backofficeVoiture.domain;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "message_mongo")
public class MessageMongo {

    @Field(name = "idMessage")
    private int idMessage;
    @Basic

    @Field(name = "idSender")
    private String idSender;
    @Basic
    @Field(name = "idReceiver")
    private String idReceiver;
    @Basic
    @Field(name = "message")
    private String message;
    @Basic
    @Field(name = "dateEnvoie")
    private Timestamp dateEnvoie;
    @Basic
    @Field(name = "dateReception")
    private Timestamp dateReception;
    @Basic
    @Field(name = "dateVue")
    private Timestamp dateVue;
    @Basic
    @Field(name = "_id")
    private String id;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
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

    public void setDateEnvoie(String dateEnvoie) {
        if(dateEnvoie == null | dateEnvoie == ""){
            this.setDateEnvoie(Timestamp.valueOf(LocalDateTime.now()));
        }else {
            dateEnvoie = dateEnvoie.replace("T", " ").concat(":00");
            this.setDateEnvoie(Timestamp.valueOf(dateEnvoie));
        }
    }

    public Timestamp getDateReception() {
        return dateReception;
    }

    public void setDateReception(String dateReception) {
        if(dateReception == null | dateReception == "") {}
        else{
            dateReception = dateReception.replace("T", " ").concat(":00");
            this.setDateReception(Timestamp.valueOf(dateReception));
        }
    }



    public void setDateReception(Timestamp dateReception) {
        this.dateReception = dateReception;
    }

    public void setDateVue(Timestamp dateVue) {
        this.dateVue = dateVue;
    }

    public Timestamp getDateVue() {
        return dateVue;
    }

    public void setDateVue(String dateVue) {
        if (dateVue == null | dateVue == ""){}
        else {
            dateVue = dateVue.replace("T", " ").concat(":00");
            this.setDateVue(Timestamp.valueOf(dateVue));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage, idSender, idReceiver, message, dateEnvoie, dateReception, dateVue);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMongo that = (MessageMongo) o;
        return idMessage == that.idMessage && Objects.equals(idSender, that.idSender) && Objects.equals(idReceiver, that.idReceiver) && Objects.equals(message, that.message) && Objects.equals(dateEnvoie, that.dateEnvoie) && Objects.equals(dateReception, that.dateReception) && Objects.equals(dateVue, that.dateVue) && Objects.equals(id, that.id);
    }
}
