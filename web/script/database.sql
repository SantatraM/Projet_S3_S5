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

create sequence seqVoyagePrix;
CREATE TABLE voyagePrix(
    idVoyagePrix varchar(20) default concat('VPV' || nextval('seqVoyagePrix')) primary key,
    idVoyage varchar(20) references formuleVoyage(idVoyage),
    prixVente float
);

create sequence seqGuideVoyage;
CREATE TABLE guideVoyage(
    idGuideVoyage varchar(20) default concat('GV' || nextval('seqGuideVoyage')) primary key,
    idAsa varchar(20) references asa(idAsa),
    idDuree varchar(20) references duree(idDuree),
    nbPersonne int
);


create sequence seqVolumeHoraire;
CREATE TABLE volumeHoraire(
    idVolumeHoraire varchar(20) default concat('VH' || nextval('seqGuideVoyage')) primary key,
    idBouquet varchar(20) references bouquet(idBouquet),
    duree int
); 

create sequence seqAsa;
CREATE TABLE asa(
    idAsa varchar(20) default concat('ASA' || nextval('seqAsa')) primary key,
    libelle varchar(20),
    salaire int
);

create sequence seqEmploye;
CREATE TABLE employe(
    idEmploye VARCHAR(20) default concat('EMP' || nextval('seqEmploye')) primary key,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    mail VARCHAR(100),
    adresse VARCHAR(50),
    dateEmbauche DATE
);

create sequence seqEmployePost;
CREATE TABLE employePost(
    idEmployePost VARCHAR(20) default concat('POST' || nextval('seqEmployePost')) primary key,
    idEmploye VARCHAR(20) REFERENCES employe(idEmploye),
    idAsa VARCHAR(20) REFERENCES asa(idAsa)
);

create sequence seqProfile;
CREATE TABLE profile(
    idProfile VARCHAR(20) default concat('PRO' || nextval('seqProfile')) primary key,
    libelle VARCHAR(30) 
);

create sequence seqProfileParAnnee;
CREATE TABLE profileParAnnee(
    idProfilParAnnee VARCHAR(20) default concat('APRO' || nextval('seqProfileParAnnee')) primary key,
    min int, 
    max int,
    idProfile VARCHAR(20) REFERENCES profile(idProfile)
);

create sequence seqTauxHoraireProfile;
CREATE TABLE tauxHoraireProfile(
    idTauxHoraireProfile VARCHAR(20) default concat('THP' || nextval('seqTauxHoraireProfile')) primary key,
    idProfile VARCHAR(20) REFERENCES profile(idProfile),
    tauxHoraire FLOAT
);