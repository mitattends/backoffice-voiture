insert into marque
values('MQ001', 'Toyota'),('MQ002', 'Mercedes');

insert into modele values
('MD0001', 'Yaris', 'MQ001'),
('MD0002', 'Hilux', 'MQ001'),
('MD0003', 'Sprinter','MQ002');

insert into axe_details values
('AX0001', 'Puissance moteur'),
('AX0002', 'Carrosserie'),
('AX0003', 'Carburant'),
('AX0004', 'Vitesse'),
('AX0005', 'Portière'),
('AX0006', 'Version'),
('AX0007', 'Type de motorisation'),
('AX0008', 'Couleur');

insert into axe_values(label, id_axe) values
    ('10-20', 'AX0001'),
    ('20-30', 'AX0001'),
    ('30-40', 'AX0001'),
    ('50-60', 'AX0001'),
    ('70-80', 'AX0001'),
    ('80-', 'AX0001'),
    ('Coupé', 'AX0002'),
    ('Convertible', 'AX0002'),
    ('Diesel', 'AX0003'),
    ('Essence', 'AX0003'),
    ('60+', 'AX0004'),
    ('100+', 'AX0004'),
    ('4 portes', 'AX0005'),
    ('5 portes', 'AX0005'),
    ('Standart', 'AX0006'),
    ('Luxe', 'AX0006'),
    ('Automatique', 'AX0007'),
    ('Manuelle', 'AX0007');

insert into axe_values(label, id_axe) values
  ('Rouge', 'AX0008'),
  ('Bleau', 'AX0008'),
  ('Gris', 'AX0008'),
  ('Violet', 'AX0008'),
  ('Jaune', 'AX0008');

-- Yaris
insert into axe_possible_values values
('AXV006','MD0001', 'AX0001', '150'),
('AXV007','MD0001', 'AX0001', '200'),
('AXV008','MD0001', 'AX0002', 'SUV'),
('AXV009','MD0001', 'AX0002', 'Coupé'),
('AXV010','MD0001', 'AX0002', 'Convertible'),
('AXV011','MD0001', 'AX0003', 'Essence'),
('AXV012','MD0001', 'AX0003', 'Diesel'),
('AXV013','MD0001', 'AX0004', '120'),
('AXV014','MD0001', 'AX0004', '130'),
('AXV015','MD0001', 'AX0005', 'Oui'),
('AXV016','MD0001', 'AX0005', 'Non'),
('AXV017','MD0001', 'AX0006', 'Standard'),
('AXV018','MD0001', 'AX0006', 'Luxe'),
('AXV019','MD0001', 'AX0007', 'Manuelle'),
('AXV020','MD0001', 'AX0007', 'Automatique');

-- Hilux

insert into axe_possible_values values
('AXV021','MD0002', 'AX0001', '250'),
('AXV022','MD0002', 'AX0001', '300'),
('AXV023','MD0002', 'AX0002', 'SUV'),
('AXV024','MD0002', 'AX0002', 'Coupé'),
('AXV025','MD0002', 'AX0002', 'Convertible'),
('AXV026','MD0002', 'AX0003', 'Essence'),
('AXV027','MD0002', 'AX0003', 'Diesel'),
('AXV028','MD0002', 'AX0004', '140'),
('AXV029','MD0002', 'AX0004', '150'),
('AXV030','MD0002', 'AX0005', 'Oui'),
('AXV031','MD0002', 'AX0005', 'Non'),
('AXV032','MD0002', 'AX0006', 'Standard'),
('AXV033','MD0002', 'AX0006', 'Luxe'),
('AXV034','MD0002', 'AX0007', 'Manuelle'),
('AXV035','MD0002', 'AX0007', 'Automatique');




-- Sprinter
insert into axe_possible_values values
('AXV036','MD0003', 'AX0001', '200'),
('AXV037','MD0003', 'AX0001', '250'),
('AXV038','MD0003', 'AX0002', 'SUV'),
('AXV039','MD0003', 'AX0002', 'Coupé'),
('AXV040','MD0003', 'AX0002', 'Convertible'),
('AXV041','MD0003', 'AX0003', 'Essence'),
('AXV042','MD0003', 'AX0003', 'Diesel'),
('AXV043','MD0003', 'AX0004', '130'),
('AXV044','MD0003', 'AX0004', '140'),
('AXV045','MD0003', 'AX0005', 'Oui'),
('AXV046','MD0003', 'AX0005', 'Non'),
('AXV047','MD0003', 'AX0006', 'Standard'),
('AXV048','MD0003', 'AX0006', 'Luxe'),
('AXV049','MD0003', 'AX0007', 'Manuelle'),
('AXV050','MD0003', 'AX0007', 'Automatique');


alter table axe_possible_values add column id_value Integer references axe_values(id_value);
