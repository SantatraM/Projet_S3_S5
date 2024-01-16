<%-- 
    Document   : rechercheVoyageParTarif
    Created on : 9 janv. 2024, 12:18:47
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
  #choix{
    width:900px;
       margin-left:300px;
       margin-right:auto;
  }
</style>
<div class="content-wrapper" id="choix">
    <div class="container-xxl flex-grow-1 container-p-y" class="choix">
        <div class="row">
            <div class="col-xl">
                <div class="card mb-4">
                    <div class="card-header d-flex justify-content-between align-items-center">
                      <h5 class="mb-0">Recherche voyage</h5>
                    </div>
                    <div class="card-body">
                        <form action="RechercheVoyageByTarifServelet" method="post" data-parsley-validate="">
                            <div class="mb-3" id="form">
                                <label for="exampleFormControlSelect1" class="form-label">Entrez deux tarifs</label>
                                <div class="col-md-10">
                                    <input class="form-control" type="number" placeholder="tarif1"  id="html5-date-input" name="tarif1" required=""/>
                                    <input class="form-control" type="number" placeholder="tarif2" id="html5-date-input" name="tarif2" required=""/>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Generer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
