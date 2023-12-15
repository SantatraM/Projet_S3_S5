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


