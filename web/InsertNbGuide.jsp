<%-- 
    Document   : InsertNbGuide
    Created on : 16 janv. 2024, 12:36:30
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
                        <h5 class="mb-0">Insertion nombre employé pour la durée courte</h5>
                    </div>
                    <div class="card-body">
                        <form action="Guide" method="post" data-parsley-validate="">
<!--                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Durée</label>
                                <select id="defaultSelect" class="form-select" name="duree">
                                <%  
                                    Vector<Duree> listesDurrees =(Vector<Duree>) request.getAttribute("listesDurrees");
                                    for (Duree duree : listesDurrees) {
                                %>
                                    <option value="<%= duree.getId() %>"><%= duree.getNom() %></option>
                                <% } %>
                                </select>
                            </div>-->
                                
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Asa</label>
                                <select id="defaultSelect" class="form-select" name="asa">
                                <%  
                                    Vector<Asa> listesAsa =(Vector<Asa>) request.getAttribute("listesAsa");
                                    for (Asa asa : listesAsa) {
                                %>
                                    <option value="<%= asa.getIdAsa() %>"><%= asa.getLibelle() %></option>
                                <% } %>
                                </select>
                            </div>
                                
                                
                            <div class="mb-3">
                              <label for="defaultSelect" class="form-label">Nombre de guide</label>
                              <div class="col-md-10">
                                  <input class="form-control" placeholder="Nombre de guide" type="number"  id="html5-date-input" name="nbGuide" required=""/>
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
