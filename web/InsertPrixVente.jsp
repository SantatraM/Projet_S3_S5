<%-- 
    Document   : InsertPrixVente.jsp
    Created on : 16 janv. 2024, 12:06:54
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
                        <h5 class="mb-0">Insertion Prix de Vente Voyage</h5>
                    </div>
                    <div class="card-body">
                        <form action="PrixVenteVoyage" method="post" data-parsley-validate="">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Voyage</label>
                                <select id="defaultSelect" class="form-select" name="voyage">
                                <%  
                                    Vector<Voyage> listesVoyages =(Vector<Voyage>) request.getAttribute("listesVoyages");
                                    for (Voyage voyage : listesVoyages) {
                                %>
                                    <option value="<%= voyage.getIdVoyage() %>"><%= voyage.getIdVoyage() %></option>
                                <% } %>
                                </select>
                            </div>
                                
                            <div class="mb-3">
                              <label for="defaultSelect" class="form-label">Prix de Vente</label>
                              <div class="col-md-10">
                                  <input class="form-control" placeholder="Prix de vente" type="number"  id="html5-date-input" name="prixVente" required=""/>
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
