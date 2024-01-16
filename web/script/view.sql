create view v_bouquetActivite as 
    select ba.*,a.nomActivite,b.nomBouquet
    from bouquetActivite ba
    join activite a on a.idActivite = ba.idActivite
    join bouquet b on b.idBouquet = ba.idBouquet;

create view v_voyage as
select v.idvoyage,cl.*,d.*,b.*
        from formuleVoyage v 
            join duree d on d.idduree = v.idduree
            join categorieLieu cl on cl.idCategorieLieu = v.idCategorieLieu
            join bouquet b on b.idbouquet = v.idbouquet;

create view v_voyageActivite as
    select v.*,a.*,av.nombreactivite
        from v_voyage v 
            join activitevoyage av on av.idvoyage=v.idvoyage
            join Activite a on a.idactivite = av.idactivite;

create view v_tarifActiviteVoyage as
    select v.*,ta.idTarifActivite,ta.tarif
        from v_voyageActivite v
            join tarifActivite ta on ta.idActivite = v.idActivite;

create view v_TarifTotalVoyage as
    select idvoyage,sum(tarif*nombreactivite) as tarif,nomcategorielieu,nombouquet
        from v_tarifActiviteVoyage 
            group by idvoyage,nomcategorielieu,nombouquet;

create or replace view v_resteStockActivite as
    select (sum(stock.quantite)-sum(sortie.quantitesortie)) as reste,a.idActivite
        from Activite a
        join sortie on sortie.idActivite = a.idActivite
        join stock on stock.idActivite=a.idActivite
        group by a.idActivite;

create or replace view v_entree as
    select stock.idActivite , a.nomActivite  , sum(stock.quantite)
        from stock
        join activite a on a.idActivite = stock.idActivite
        group by stock.idActivite , a.nomActivite ;

create or replace view v_sortie as
    select sortie.idActivite , a.nomActivite , sum(sortie.quantiteSortie)
        from sortie
        join activite a on a.idActivite = sortie.idActivite
        group by sortie.idActivite , a.nomActivite  ;

create or replace view v_activitevoyage as
    select av.* , a.nomActivite
        from activiteVoyage av 
            join activite a on a.idActivite = av.idActivite;

create or replace view v_etatStockActivite as
    select ve.idActivite , ve.nomActivite , ve.sum as totalEntree ,
        vs.sum as totalSortie , coalesce(ve.sum - vs.sum , ve.sum) as reste
        from v_entree ve
        left join v_sortie vs on vs.idActivite =  ve.idActivite;
