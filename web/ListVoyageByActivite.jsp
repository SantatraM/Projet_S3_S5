<%-- 
    Document   : ListVoyageByActivite
    Created on : 4 janv. 2024, 10:23:37
    Author     : hp
--%>

<%@page import="java.util.Vector"%>
<%@page import="classes.Voyage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="content-wrapper" style="margin-left: 22%; width: 65%">
<form action="RechercheVoyageServelet" method="post">
    <nav class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme" id="layout-navbar">
        <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
            <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                <i class="bx bx-menu bx-sm"></i>
            </a>
        </div>

        <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
                  <!-- Search -->
            <div class="navbar-nav align-items-center">
                <div class="nav-item d-flex align-items-center">
                    <button type="submit" style="border: none; background-color: white">
                        <i class="bx bx-search fs-4 lh-0"></i>
                    </button>
                    <input
                        type="text"
                        class="form-control border-0 shadow-none"
                        placeholder="Search..."
                        aria-label="Search..."
                        name="activite"
                    />
                </div>
            </div>
                  <!-- /Search -->
        </div>
    </nav>
</form>
    
    <div class="container-xxl flex-grow-1 container-p-y">
        <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Listes des</span> voyages</h4>
        <div class="card">
            <h5 class="card-header">Voyages</h5>
            <div class="text-nowrap">
                <table class="table">
                    <tr>
                        <th><strong>idVoyage</strong></th>
                        <th><strong>CategorieLieu</strong></th>
                        <th><strong>bouquet</strong></th>
                        <th><strong>Activite</strong></th>
                        <th><strong>Nombres Activites</strong></th>
                        <th></th>
                    </tr>
                    <tbody >
                        <%
                            Vector<Voyage> listesVoyage = (Vector<Voyage>) request.getAttribute("listeVoyageActivite");
                            for(Voyage voyage : listesVoyage) {
                        %>
                        <tr>
                            <td><%= voyage.getIdVoyage() %></td>
                            <td><span class="badge bg-label-warning me-1"><%= voyage.getCategorieLieu() %></span></td>
                            <td><span class="badge bg-label-success me-1"><%= voyage.getBouquet() %></span></td>
                            <td><%= voyage.getActivites() %></td>
                            <th><%= voyage.getNbactivite()%></th>
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