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


create or replace view v_GuideVoyage as
    select gv.* , d.nomduree , a.libelle , a.salaire
        from GuideVoyage gv
        join Duree d on d.idduree = gv.idduree
        join Asa a on a.idAsa = gv.idAsa;

create or replace view v_volumeHoraire as
    select vh.* , b.nombouquet
        from volumeHoraire vh 
        join bouquet b on b.idbouquet = vh.idbouquet;

create or replace view v_GuideHoraireVoyage as
    select v.idvoyage , vg.* , vh.* 
        FROM v_voyage v
        join v_guidevoyage vg on vg.idduree = v.idduree
        join v_volumehoraire vh on  vh.idbouquet = v.idbouquet;

create or replace view v_totalHoraireGuideVoyage as
    select  idvoyage,idbouquet,nombouquet,idduree,nomduree,nbpersonne,(nbpersonne * duree) as totalHeureGuide ,
    salaire * (nbpersonne * duree) as salaireTotal
        from v_GuideHoraireVoyage
        group by idvoyage,idbouquet,nombouquet,idduree,nomduree,nbpersonne,duree,salaire;

create or replace view v_prixDeRevient as
    select th.idvoyage , (vt.tarif + th.salaireTotal) as prixderevient
        from v_totalHoraireGuideVoyage th
        join v_tariftotalvoyage vt on vt.idvoyage = th.idvoyage;

create or replace view v_benefice as
    select pv.idvoyage , (pv.prixVente - vp.prixderevient) as benefice
        from voyagePrix pv 
        join v_prixDeRevient vp on vp.idvoyage = pv.idvoyage;

reate or replace view v_employePoste as 
    SELECT e.* , asa.* , (extract(year from current_date) - extract(year from e.dateEmbauche)) as anneeDeTravail
    from employePost ep 
    join employe e on e.idEmploye = ep.idEmploye 
    join asa on asa.idAsa = ep.idAsa ;

CREATE OR REPLACE VIEW v_employeProfile AS
    SELECT 
        v.*,
        ppa.idProfile,
        p.libelle as profile,
        ppa.min,
        ppa.max
    FROM 
        v_employePoste v
        LEFT JOIN profileParAnnee ppa ON v.anneeDeTravail BETWEEN ppa.min AND ppa.max
        join profile p on p.idprofile = ppa.idprofile;


create or REPLACE view v_tauxHoraireProfile AS
    SELECT ep.* , t.tauxHoraire 
    FROM v_employeProfile ep 
    join tauxHoraireProfile t on t.idProfile = ep.idProfile;