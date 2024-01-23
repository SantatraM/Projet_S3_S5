<%-- 
    Document   : insertTauxHoraire
    Created on : 23 janv. 2024, 15:51:34
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
                      <h5 class="mb-0">Insertion de taux horaire d'un agent simple</h5>
                    </div>
                    <div class="card-body">
                        <form action="InsertTauxHoraire" method="post" data-parsley-validate="">
                          
                            <div class="mb-3" id="form">
                                <label for="duree" class="form-label">Entrez le taux horaire</label>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Taux horaire" class="form-control" type="text"  id="html5-date-input" name="txh" required=""/>
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

