<%-- 
    Document   : insertTarifActivite
    Created on : 9 janv. 2024, 11:23:08
    Author     : hp
--%>

<%@page import="java.util.Vector"%>
<%@ page import="classes.*"%>
<%@ include file="header.jsp" %>
<%--<%@ include file="header.jsp" %>--%>

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
                        <h5 class="mb-0">Insertion d'activites d'un bouquet</h5>
                    </div>
                    <div class="card-body">
                        <form action="TarifActiviteServelet" method="post" data-parsley-validate="">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Activites</label>
                                <select id="defaultSelect" class="form-select" name="activite">
                                <%  
                                    Vector<Activite> listesActivite =(Vector<Activite>) request.getAttribute("listeActivites");
                                    for (Activite activite : listesActivite) {
                                %>
                                    <option value="<%= activite.getIdActivite() %>"><%= activite.getNomActivite() %></option>
                                <% } %>
                                </select>
                            </div>
                            <div class="mb-3" id="form">
                                <label for="exampleFormControlSelect1" class="form-label">Entrez le tarif</label>
                                <div class="col-md-10">
                                    <input class="form-control" type="number"  id="html5-date-input" name="tarif" required=""/>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>