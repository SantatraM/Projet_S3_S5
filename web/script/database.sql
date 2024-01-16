CREATE DATABASE voyage;

CREATE sequence seqActivite;
CREATE Table activite(
    idActivite VARCHAR(20) DEFAULT concat('ACT' || nextval('seqActivite')) PRIMARY KEY,
    nomActivite VARCHAR(50)
);

CREATE sequence seqCategorieLieu;
CREATE Table categorieLieu(
    idCategorieLieu VARCHAR(20) DEFAULT concat('CAT' || nextval('seqCategorieLieu')) PRIMARY KEY,
    nomCategorieLieu VARCHAR(50)
);

CREATE sequence seqBouquet;
CREATE Table bouquet(
    idBouquet VARCHAR(20) DEFAULT concat('CAT' || nextval('seqBouquet')) PRIMARY KEY,
    nomBouquet VARCHAR(50)
);

CREATE sequence seqBouquetActivite;
CREATE Table bouquetActivite(
    idBouquetActivite VARCHAR(20) DEFAULT concat('BACT' || nextval('seqBouquetActivite')) PRIMARY KEY,
    idBouquet varchar(20),
    idActivite VARCHAR(20),
    foreign key (idBouquet) references bouquet(idBouquet),
    foreign key (idActivite) references activite(idActivite)
);


CREATE sequence seqDuree;
CREATE Table duree(
    idDuree VARCHAR(20) DEFAULT concat('DR' || nextval('seqDuree')) PRIMARY KEY,
    nomDuree varchar(20),
    nbJour INT
);


CREATE sequence seqFormuleVoyage;
CREATE TABLE formuleVoyage(
    idVoyage VARCHAR(20) DEFAULT concat('VOY' || nextval('seqFormuleVoyage')) PRIMARY KEY,
    idDuree VARCHAR(20),
    idCategorieLieu VARCHAR(20),
    idBouquet VARCHAR(20),
    foreign key(idDuree) references duree(idDuree),
    foreign key(idCategorieLieu) references categorieLieu(idCategorieLieu),
    foreign key(idBouquet) references bouquet(idBouquet)
);


create sequence seqActiviteVoyage;
CREATE TABLE activiteVoyage(
    idActiviteVoyage VARCHAR(20) DEFAULT concat('ACTV' || nextval('seqActiviteVoyage')) primary key,
    idVoyage VARCHAR(20),
    idActivite VARCHAR(20),
    nombreActivite int,
    foreign key(idVoyage) references formuleVoyage(idVoyage),
    foreign key(idActivite) references Activite(idActivite)
);

create sequence seqTarifActivite;
CREATE TABLE tarifActivite(
    idTarifActivite VARCHAR(20) DEFAULT concat('TAR' || nextval('seqTarifActivite')) primary key,
    idActivite VARCHAR(20) references activite(idActivite),
    tarif float
);

create sequence seqStock;
CREATE TABLE stock(
    idStock varchar(20) default concat('STO' || nextval('seqStock')) primary key,
    idActivite varchar(20) references activite(idActivite),
    quantite float,
    dateStock date
);

create sequence seqSortie;
CREATE TABLE sortie(
    idStock varchar(20) default concat('STO' || nextval('seqStock')) primary key,
    idActivite varchar(20) references activite(idActivite),
    quantiteSortie float,
    dateSortie date default current_date
);


