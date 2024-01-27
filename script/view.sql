
create table mois(
                     id_mois serial primary key ,
                     nom varchar(20) unique not null
);

INSERT INTO mois (nom) VALUES ('Janvier');
INSERT INTO mois (nom) VALUES ('Février');
INSERT INTO mois (nom) VALUES ('Mars');
INSERT INTO mois (nom) VALUES ('Avril');
INSERT INTO mois (nom) VALUES ('Mai');
INSERT INTO mois (nom) VALUES ('Juin');
INSERT INTO mois (nom) VALUES ('Juillet');
INSERT INTO mois (nom) VALUES ('Août');
INSERT INTO mois (nom) VALUES ('Septembre');
INSERT INTO mois (nom) VALUES ('Octobre');
INSERT INTO mois (nom) VALUES ('Novembre');
INSERT INTO mois (nom) VALUES ('Décembre');

create or replace view
    v_nombre_annonce_par_mois_par_annee as
select count(a.id_annonce) nombre,
       m.id_mois,
       m.nom,
       extract(year from a.date_annonce),
       a.etat
from mois m
         left join annonce  a
                   on m.id_mois = extract(month from a.date_annonce)
group by m.id_mois, m.nom, extract(year from a.date_annonce),a.etat;

select * from v_nombre_annonce_par_mois_par_annee;

create or replace view v_modele_annonce
as select distinct a.id_annonce,
                   dm.id_modele,
                   m.nom modele_nom,
                   mq.nom marque_nom,
                   mq.id_marque,
                   a.date_annonce
   from annonce a
            join details_modele dm
                 on a.id_annonce = dm.id_annonce
            join modele m on dm.id_modele = m.id_modele
            join marque mq on m.id_marque = mq.id_marque
;

create or replace view
    v_nombre_vente_modele as
select count(id_annonce) nombre,
       m.id_modele,
       extract(year from date_annonce),
       m.nom modele_nom
from modele m join  v_modele_annonce vma
                    on m.id_modele = vma.id_modele
group by m.id_modele, m.nom, extract(year from date_annonce)
order by nombre desc ;

select * from v_nombre_vente_modele;

create or replace view
    v_nombre_vente_marque as
select count(id_annonce) nombre,
       m.id_marque,
       m.nom marque_nom,
       extract(year from vma.date_annonce)
from marque m join v_modele_annonce vma
                   on m.id_marque = vma.id_marque
group by m.id_marque, m.nom, extract(year from date_annonce)
order by nombre desc
;