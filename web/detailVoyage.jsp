<%-- 
    Document   : detailVoyage
    Created on : 4 janv. 2024, 14:43:18
    Author     : hp
--%>

<%@page import="classes.Voyage"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="content-wrapper" style="margin-left: 22%; width: 65%">
<div class="container-xxl flex-grow-1 container-p-y">
        <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Details du</span> voyages</h4>
        <div class="card">
            <h5 class="card-header">Voyages</h5>
            <div class="text-nowrap">
                <table class="table">
                    <tr>
                        <th><strong>Bouquet</strong></th>
                        <th><strong>Activites</strong></th>
                        <th><strong>Nombre activite</strong></th>
                    </tr>
                    <tbody >
                        <%
                            Vector<Voyage> listesVoyage = (Vector<Voyage>) request.getAttribute("listeVoyage");
                            for(Voyage voyage : listesVoyage) {
                        %>
                        <tr class="table-danger">
                            <th><span class="badge bg-label-success me-1"><%= voyage.getBouquet() %></span></th>
                            <th><span class="badge bg-label-warning me-1"><%= voyage.getActivites() %></span></th>
                            <th><%= voyage.getNbactivite() %></th>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
</div>