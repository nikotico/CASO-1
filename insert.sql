
INSERT INTO RoleUser (type) VALUES ('managers');
INSERT INTO RoleUser (type) VALUES ('user');

INSERT INTO Canton (name) VALUES ('Alajuela');
INSERT INTO Canton (name) VALUES ('Atenas');
INSERT INTO Canton (name) VALUES ('Naranjo');
INSERT INTO Canton (name) VALUES ('Grecia');

INSERT INTO KpiXType (ente) VALUES ('KM');
INSERT INTO KpiXType (ente) VALUES ('Books');
INSERT INTO KpiXType (ente) VALUES ('Computers');
INSERT INTO KpiXType (ente) VALUES ('Trees');

INSERT INTO Party (name,flag_path) VALUES ('PLN','foto1');
INSERT INTO Party (name,flag_path) VALUES ('PUSC','foto2');
INSERT INTO Party (name,flag_path) VALUES ('PAC','foto3');
INSERT INTO Party (name,flag_path) VALUES ('PSD','foto4');

INSERT INTO Userr (user_type, party_id, name, photo_path, bio) VALUES (1, 1, 'Pablo Perez', 'fotoPablo', 'Ing en Computacion');
INSERT INTO Userr (user_type, party_id, name, photo_path, bio) VALUES (1, 2, 'Ana Dinarte', 'fotoAna', 'Biologa');
INSERT INTO Userr (user_type, party_id, name, photo_path, bio) VALUES (1, 3, 'Juan Bustos', 'fotoJuan', 'Pastor');
INSERT INTO Userr (user_type, party_id, name, photo_path, bio) VALUES (1, 4, 'Carla Gonzales', 'fotoCarla', 'Director Marketing');

INSERT INTO [Plan] (name) VALUES ('Nuevas carreteras');
INSERT INTO [Plan] (name) VALUES ('Ayuda a escuelas');
INSERT INTO [Plan] (name) VALUES ('Mejor tecnologia');
INSERT INTO [Plan] (name) VALUES ('Mas zonas verdes');

INSERT INTO PlansPerParty (party_id,plan_id) VALUES (1,1);
INSERT INTO PlansPerParty (party_id,plan_id) VALUES (2,2);
INSERT INTO PlansPerParty (party_id,plan_id) VALUES (3,3);
INSERT INTO PlansPerParty (party_id,plan_id) VALUES (4,4);

INSERT INTO [Action] (name) VALUES ('Asfaltado o restauracion de las carretera');
INSERT INTO [Action] (name) VALUES ('Entrega de libros a la diferentes escuelas');
INSERT INTO [Action] (name) VALUES ('Soporte tecnologico con computadoras');
INSERT INTO [Action] (name) VALUES ('Plantar arboles en zonas publicas');

INSERT INTO ActionsPerPlan (action_id,plan_id) VALUES (1,1);
INSERT INTO ActionsPerPlan (action_id,plan_id) VALUES (2,2);
INSERT INTO ActionsPerPlan (action_id,plan_id) VALUES (3,3);
INSERT INTO ActionsPerPlan (action_id,plan_id) VALUES (4,4);

/*5 PLN*/
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Asfaltado de la carretera de ese canton', 53, 1, 1, '2023-1-1', 1);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Lipieza de carretera', 82, 1, 1, '2023-8-28', 1);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Restauracion de las carretera', 45, 1, 1, '2021-4-3', 1);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Mantemiento a calles nacionales y publicas', 16, 1, 1, '2022-6-17', 1);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Restauracion de las carretera', 64, 1, 1, '2022-6-28', 1);

/*3 PUSC*/
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Entrega de libros a la escuela de Dulce nombre', 71, 2, 2, '2023-2-23', 2);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Entrega de libros a la escuela de Caballo Blanco', 92, 2, 2, '2022-2-2', 2);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Restaurar y entregar nuevos libros a la escuela de la zona sur', 52, 2, 2, '2022-5-18', 2);

/*4 PAC*/
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Entrega de computadoras a los INA de la zona', 96, 3, 3, '2021-9-3', 3);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Dar computadoras a escuelas de bajos recurso', 84, 3, 3, '2022-3-1', 3);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Sumistar equipo tecnologico a los colegios cercanos', 83, 3, 3, '2022-1-17', 3);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Nuevas pc', 81, 3, 3, '2023-4-16', 3);

/*4 PSD*/
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Plantar arboles en zonas publicas en conjunto con el ICE', 59, 4, 4, '2022-4-12', 4);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Plantar arboles frente a colegios y escuelas', 50, 4, 4, '2021-10-7', 4);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Limpieza de parques y nuevos arboles', 31, 4, 4, '2022-9-23', 4);
insert into Deliverable (detail, kpiCant, kpi_type, action_id, ready_date, createBy) values ('Plantar arboles en zonas publicas', 3, 4, 4, '2023-2-5', 4);

insert into DelivPerCant (deli_id, canton_id) values (1, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (2, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (3, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (4, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (5, FLOOR(RAND()*(4-1+1)+1));

insert into DelivPerCant (deli_id, canton_id) values (6, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (7, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (8, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (9, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (10, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (11, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (12, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (13, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (14, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (15, FLOOR(RAND()*(4-1+1)+1));
insert into DelivPerCant (deli_id, canton_id) values (16, FLOOR(RAND()*(4-1+1)+1));


