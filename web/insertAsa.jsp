<%-- 
    Document   : insertAsa.jsp
    Created on : 16 janv. 2024, 13:18:57
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
                      <h5 class="mb-0">Ajout Asa</h5>
                    </div>
                    <div class="card-body">
                        <form action="AsaServelet" method="post" data-parsley-validate="">
                          
                            <div class="mb-3" id="form">
                                <label for="duree" class="form-label">Entrez un Travail</label>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Libelle Asa" class="form-control" type="text"  id="html5-date-input" name="libelle" required=""/>
                                </div>
                               
                                <div class="col-md-10">
                                    <input class="form-control" placeholder="Salaire" type="number"  id="html5-date-input" name="salaire" required=""/>
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


