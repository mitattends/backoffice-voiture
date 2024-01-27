create sequence seq_administrateur;

create table adminitrateur(
    idAdministrateur varchar(20) primary key ,
    nom varchar(200) not null ,
    prenom varchar(200) not null ,
    email varchar(200) not null unique ,
    motDePasse varchar(200) not null
);