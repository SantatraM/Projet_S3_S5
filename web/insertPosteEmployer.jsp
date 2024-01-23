<%-- 
    Document   : insertPosteEmployer
    Created on : 23 janv. 2024, 15:24:12
    Author     : hp
--%>

<%@page import="classes.Asa"%>
<%@page import="java.util.Vector"%>
<%@page import="classes.Employer"%>
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
                        <form action="posteEmployer" method="post" data-parsley-validate="">
                          
                            <div class="mb-3" id="form">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Employer</label>
                                <select id="defaultSelect" class="form-select" name="employe">
                                <%  
                                    Vector<Employer> listesEmployer =(Vector<Employer>) request.getAttribute("listeEmployer");
                                    for (Employer e : listesEmployer) {
                                %>
                                    <option value="<%= e.getId() %>"><%= e.getNom() %> <%= e.getPrenom() %></option>
                                <% } %>
                                </select>
                            </div>

                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Asa</label>
                                <select id="defaultSelect" class="form-select" name="asa">
                                <%  
                                    Vector<Asa> listesAsa =(Vector<Asa>) request.getAttribute("listAsa");
                                    for (Asa a : listesAsa) {
                                %>
                                    <option value="<%= a.getIdAsa()%>"><%= a.getLibelle() %></option>
                                <% } %>
                                </select>
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

