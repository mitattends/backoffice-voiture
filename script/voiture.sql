create sequence details_modele_id_details_model_seq;
create sequence seq_annonce;
create sequence seq_axe_details;
create sequence seq_axe_possible_values;
create sequence seq_details_modele;
create sequence seq_historique;
create sequence seq_marque;
create sequence seq_modele;
create sequence seq_utilisateur;


create table utilisateur(
    id_utilisateur varchar(20) primary key,
    nom varchar(200),
    prenom varchar(200),
    date_naissance date,
    email varchar(200),
    mot_de_passe varchar(200)
);

create table marque(
    id_marque varchar(20) primary key,
    nom varchar(200)
);

create table modele(
    id_modele varchar(20) primary key,
    nom varchar(200),
    id_marque varchar(20),
    foreign key(id_marque) references marque(id_marque)
);

create table axe_details(
    id_axe varchar(20) primary key,
    nom varchar(200)
);

drop table axe_possible_values;

create table axe_possible_values(
    id_axe_possible_values varchar(20) primary key,
    id_modele varchar(20) references modele(id_modele),
    id_axe varchar(20),
    value varchar(200),
    foreign key(id_axe) references axe_details(id_axe)
);

create table annonce(
    id_annonce varchar(20) primary key,
    annee varchar(10),
    kilometrage double precision,
    date_annonce timestamp default now(),
    description varchar(200),
    etat int,
    id_utilisateur varchar(20) references utilisateur(id_utilisateur)
);

create table details_modele(
    id_details_model varchar primary key ,
    id_modele varchar(20) references modele(id_modele),
    id_axe varchar(20),
    value varchar(200),
    id_annonce varchar(20) references annonce(id_annonce),
    foreign key(id_axe) references axe_details(id_axe)
);
alter table details_modele add column id_details_model varchar(20) primary key

create table historique_modification_annonce(
    id_annonce varchar(20) references annonce(id_annonce),
    id_utilisateur varchar(20) references utilisateur(id_utilisateur)
);
