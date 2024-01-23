<%-- 
    Document   : InsertDureeHoraire
    Created on : 16 janv. 2024, 12:57:30
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
                        <h5 class="mb-0">Insertion volume horaire pour un bouquet</h5>
                    </div>
                    <div class="card-body">
                        <form action="VolumeHoraire" method="post" data-parsley-validate="">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Bouquet</label>
                                <select id="defaultSelect" class="form-select" name="bouquet">
                                <%  
                                    Vector<Bouquet> listesBouquets =(Vector<Bouquet>) request.getAttribute("listesBouquets");
                                    for (Bouquet bouquet : listesBouquets) {
                                %>
                                    <option value="<%= bouquet.getIdBouquet() %>"><%= bouquet.getNomBouquet() %></option>
                                <% } %>
                                </select>
                            </div>
                             
                                
                            <div class="mb-3">
                              <label for="defaultSelect" class="form-label">Volume horaire</label>
                              <div class="col-md-10">
                                  <input class="form-control" placeholder="Volume horaire" type="number"  id="html5-date-input" name="volumeHoraire" required=""/>
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

