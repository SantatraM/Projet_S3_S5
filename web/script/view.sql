create view v_bouquetActivite as 
    select ba.*,a.nomActivite,b.nomBouquet
    from bouquetActivite ba
    join activite a on a.idActivite = ba.idActivite
    join bouquet b on b.idBouquet = ba.idBouquet;