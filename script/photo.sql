create table photo(
    id_photo serial primary key ,
    text name,
    id_annonce varchar(20) references annonce(id_annonce)
)