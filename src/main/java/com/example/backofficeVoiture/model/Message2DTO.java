package com.example.backofficeVoiture.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message2DTO {
    String message;
    String idSender;
    String idReceiver;
    String idAnnonce;

    String senderName;
    String receiverName;
}
