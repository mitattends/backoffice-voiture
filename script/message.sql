create table message
(
    id_message serial primary key ,
    id_sender varchar(20) references voiture.public.utilisateur(id_utilisateur),
    id_receiver varchar(20) references voiture.public.utilisateur(id_utilisateur),
    message text,
    date_envoie timestamp,
    date_reception timestamp,
    date_vue timestamp
);