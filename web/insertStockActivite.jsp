<%-- 
    Document   : insertStockActivite
    Created on : 11 janv. 2024, 13:33:44
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
                        <h5 class="mb-0">Insertion de stock d'activité</h5>
                    </div>
                    <div class="card-body">
                        <form action="stockActivite" method="post" data-parsley-validate="">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Activité</label>
                               
                                <select id="defaultSelect" class="form-select" name="activite">
                                <%  
                                   
                                    Vector<Activite> listesActivite =(Vector<Activite>) request.getAttribute("listeActivite");
                                    for (Activite activite : listesActivite) {
                                %>
                                    <option value="<%= activite.getIdActivite() %>"><%= activite.getNomActivite() %></option>
                                <% } %>
                                </select>
                            </div>
                                
                            <div class="mb-3">
                              <label for="defaultSelect" class="form-label">Quantité</label>
                              <div class="col-md-10">
                                  <input class="form-control" placeholder="Quantite" type="number"  id="html5-date-input" name="quantite" required=""/>
                              </div>
                            </div>
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Date</label>
                                <div class="col-md-10">
                                  <input class="form-control" type="date"  id="html5-date-input" name="dateStock" required=""/>
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
