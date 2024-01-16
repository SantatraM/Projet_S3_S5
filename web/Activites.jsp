<%-- 
    Document   : Activites
    Created on : 16 janv. 2024, 09:32:01
    Author     : hp
--%>

<%@page import="classes.Activite"%>
<%@page import="java.util.Vector"%>
<%@ include file="header.jsp" %>
<div class="content-wrapper" style="margin-left: 22%; width: 65%">
    <div class="container-xxl flex-grow-1 container-p-y">
        <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Listes des</span> Activites</h4>
        <div class="card">
            <div class="text-nowrap">
                <table class="table">
                    <tr>
                        <th><strong>Activite</strong></th>
                        <th><strong>reste</strong></th>
                    </tr>
                    <tbody class="table-border-bottom-0">
                        <%
                            Vector<Activite> listesActivites = (Vector<Activite>) request.getAttribute("listeActivites");
                            for(Activite activite : listesActivites) {
                        %>
                        <tr>
                            <td><%= activite.getNomActivite() %></td>
                            <td><%= activite.getReste() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
</div>
