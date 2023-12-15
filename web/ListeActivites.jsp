<%-- 
    Document   : ListeActivites
    Created on : 15 déc. 2023, 10:29:47
    Author     : hp
--%>

<%@page import="classes.ActiviteBouquet"%>
<%@page import="java.util.Vector"%>
<%@ include file="index.html" %>
<div class="content-wrapper" style="margin-left: 22%; width: 65%">
    <div class="container-xxl flex-grow-1 container-p-y">
        <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Listes </span> Activites</h4>
        <div class="card">
            <h5 class="card-header">Pour le Bouquet : <%= request.getAttribute("bouquet") %></h5>
            <div class="text-nowrap">
                <table class="table">
                    <tr>
                        <th><strong>Activites</strong></th>
                    </tr>
                    <tbody class="table-border-bottom-0">
                        <%
                            Vector<ActiviteBouquet> listesActivites = (Vector<ActiviteBouquet>) request.getAttribute("listesActivite");
                            for(ActiviteBouquet activite : listesActivites) {
                        %>
                        <tr>
                            <td><%= activite.getActivite() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>
</div>
