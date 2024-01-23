<%-- 
    Document   : listeEmployes
    Created on : 23 janv. 2024, 16:36:18
    Author     : hp
--%>

<%@page import="classes.Employer"%>
<%@page import="java.util.Vector"%>
<%@page import="classes.Voyage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="content-wrapper" style="margin-left: 22%; width: 65%">
    <div class="container-xxl flex-grow-1 container-p-y">
        <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Listes des</span> employes</h4>
        <div class="card">
            <h5 class="card-header">Employes </h5>
            <div class="text-nowrap">
                <table class="table">
                    <tr>
                        <th><strong>Nom</strong></th>
                        <th><strong>Prenom</strong></th>
                        <th>profile</th>
                        <th>tauxHoraire</th>
                    </tr>
                    <tbody >
                        <%
                            Vector<Employer> listes = (Vector<Employer>) request.getAttribute("listeEmp");
                            for(Employer emp : listes) {
                        %>
                        <tr>
                            <td><%= emp.getNom() %></td>
                            <td><%= emp.getPrenom() %></td>
                            
                            <th><%= emp.getProfile() %></th>
                            <th><%= emp.getTauxhoraire() %></th>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
</div>