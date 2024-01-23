<%-- 
    Document   : insertBouquetActivite
    Created on : 12 déc. 2023, 17:45:44
    Author     : hp
--%>
<%@page import="java.util.Vector"%>
<%@ page import="classes.*"%>
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
                        <h5 class="mb-0">Insertion d'activites d'un bouquet</h5>
                    </div>
                    <div class="card-body">
                        <form action="BouquetActiviteServelet" method="post" data-parsley-validate="">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Bouquet</label>
                                <select id="defaultSelect" class="form-select" name="bouquet">
                                <%  
                                    Vector<Bouquet> listesBouquet =(Vector<Bouquet>) request.getAttribute("listeBouquet");
                                    for (Bouquet bouquet : listesBouquet) {
                                %>
                                    <option value="<%= bouquet.getIdBouquet() %>"><%= bouquet.getNomBouquet() %></option>
                                <% } %>
                                </select>
                            </div>
                                
                            <div class="mb-3">
                              <label for="defaultSelect" class="form-label">Activites</label>
                                <%  
                                    Vector<Activite> listesActivite =(Vector<Activite>) request.getAttribute("listeActivite");
                                    for (Activite activite : listesActivite) {
                                %>
                                    <input class="form-check-input" type="checkbox" value="<%= activite.getIdActivite() %>" id="defaultCheck1" name="activite" required=""/>
                                    <label class="form-check-label" for="defaultCheck1"><%= activite.getNomActivite() %> </label>
                                <% } %>
                            </div>
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>