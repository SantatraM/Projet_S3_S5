<%-- 
    Document   : insertEmployer
    Created on : 23 janv. 2024, 14:49:07
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
                      <h5 class="mb-0">Insertion d'employer</h5>
                    </div>
                    <div class="card-body">
                        <form action="InsertEmployer" method="post" data-parsley-validate="">
                          
                            <div class="mb-3" id="form">
                                <label for="duree" class="form-label">Entrez les information de l'employer</label>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Nom" class="form-control" type="text"  id="html5-date-input" name="nomEmployer" required=""/>
                                </div>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Prénom" class="form-control" type="text"  id="html5-date-input" name="prenomEmployer" required=""/>
                                </div>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Email" class="form-control" type="email"  id="html5-date-input" name="emailEmployer" required=""/>
                                </div>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Adresse" class="form-control" type="text"  id="html5-date-input" name="adresseEmployer" required=""/>
                                </div>
                                <div class="col-md-10 mb-3">
                                    <input placeholder="Date d'embauche" class="form-control" type="date"  id="html5-date-input" name="dtnEmbauche" required=""/>
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

