<%-- 
    Document   : insertDuree
    Created on : 19 déc. 2023, 15:00:19
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
                      <h5 class="mb-0">Ajout Duree</h5>
                    </div>
                    <div class="card-body">
                        <form action="DureeServelet" method="post" data-parsley-validate="">
                          
                            <div class="mb-3" id="form">
                                <label for="duree" class="form-label">Entrez une Durée</label>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Nom de la durée" class="form-control" type="text"  id="html5-date-input" name="duree" required=""/>
                                </div>
                               
                                <div class="col-md-10">
                                    <input class="form-control" placeholder="Nombre de jour" type="number"  id="html5-date-input" name="nbJour" required=""/>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Entrer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

