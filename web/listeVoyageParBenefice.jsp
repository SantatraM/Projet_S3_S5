<%-- 
    Document   : listeVoyageParBenefice
    Created on : 16 janv. 2024, 14:15:20
    Author     : hp
--%>

<%@page import="java.util.Vector"%>
<%@page import="classes.Voyage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="content-wrapper" style="margin-left: 22%; width: 65%">
    <div class="container-xxl flex-grow-1 container-p-y">
        <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Listes des</span> voyages</h4>
        <div class="card">
            <h5 class="card-header">Voyages</h5>
            <div class="text-nowrap">
                <table class="table">
                    <tr>
                        <th><strong>idVoyage</strong></th>
                        <th><strong>Benefice</strong></th>
                        <th></th>
                    </tr>
                    <tbody >
                        <%
                            Vector<Voyage> listesVoyage = (Vector<Voyage>) request.getAttribute("listevoyages");
                            for(Voyage voyage : listesVoyage) {
                        %>
                        <tr>
                            <td><%= voyage.getIdVoyage() %></td>
                            <td><%= voyage.getBenefice()%></td>
                            
                            <th>
                                <a class="dropdown-item" href="DetailVoyageServelet?idvoyage=<%= voyage.getIdVoyage() %>"><span class="badge bg-label-info me-1"> Voir details</span></a>
                            </th>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
</div>