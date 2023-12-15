<%-- 
    Document   : ActiviteBouquet
    Created on : 15 déc. 2023, 10:00:40
    Author     : hp
--%>

<%@page import="java.util.Vector"%>
<%@ page import="classes.*"%>
<%@ include file="index.html" %>

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
                        <h5 class="mb-0">Recherchez les activites d'un bouquet</h5>
                    </div>
                    <div class="card-body">
                        <form action="BouquetActivite" method="post">
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
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
