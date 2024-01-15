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
('AX0007', 'Type de motorisation');

-- Yaris

insert into axe_possible_values values
('AXV006','MD0001', 'AX0001', '150'),
('AXV007','MD0000001', 'AX0001', '200'),
('AXV008','MD001', 'AX0002', 'SUV'),
('AXV009','MD001', 'AX0002', 'Coupé'),
('AXV010','MD001', 'AX0002', 'Convertible'),
('AXV011','MD001', 'AX0003', 'Essence'),
('AXV012','MD001', 'AX0003', 'Diesel'),
('AXV013','MD001', 'AX0004', '120'),
('AXV014','MD001', 'AX0004', '130'),
('AXV015','MD001', 'AX0005', 'Oui'),
('AXV016','MD001', 'AX0005', 'Non'),
('AXV017','MD001', 'AX0006', 'Standard'),
('AXV018','MD001', 'AX0006', 'Luxe'),
('AXV019','MD001', 'AX0007', 'Manuelle'),
('AXV020','MD001', 'AX0007', 'Automatique');

-- Hilux

insert into axe_possible_values values
('AXV021','MD002', 'AX0001', '250'),
('AXV022','MD002', 'AX0001', '300'),
('AXV023','MD002', 'AX0002', 'SUV'),
('AXV024','MD002', 'AX0002', 'Coupé'),
('AXV025','MD002', 'AX0002', 'Convertible'),
('AXV026','MD002', 'AX0003', 'Essence'),
('AXV027','MD002', 'AX0003', 'Diesel'),
('AXV028','MD002', 'AX0004', '140'),
('AXV029','MD002', 'AX0004', '150'),
('AXV030','MD002', 'AX0005', 'Oui'),
('AXV031','MD002', 'AX0005', 'Non'),
('AXV032','MD002', 'AX0006', 'Standard'),
('AXV033','MD002', 'AX0006', 'Luxe'),
('AXV034','MD002', 'AX0007', 'Manuelle'),
('AXV035','MD002', 'AX0007', 'Automatique');

-- Sprinter
insert into axe_possible_values values
('AXV036','MD0003', 'AX0001', '200'),
('AXV037','MD0003', 'AX0001', '250'),
('AXV038','MD0003', 'AX0002', 'SUV'),
('AXV039','MD0003', 'AX0002', 'Coupé'),
('AXV040','MD0003', 'AX0002', 'Convertible'),
('AXV041','MD003', 'AX0003', 'Essence'),
('AXV042','MD003', 'AX0003', 'Diesel'),
('AXV043','MD003', 'AX0004', '130'),
('AXV044','MD003', 'AX0004', '140'),
('AXV045','MD003', 'AX0005', 'Oui'),
('AXV046','MD003', 'AX0005', 'Non'),
('AXV047','MD003', 'AX0006', 'Standard'),
('AXV048','MD003', 'AX0006', 'Luxe'),
('AXV049','MD003', 'AX0007', 'Manuelle'),
('AXV050','MD003', 'AX0007', 'Automatique');