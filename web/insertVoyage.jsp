<%-- 
    Document   : insertVoyage
    Created on : 19 déc. 2023, 15:20:56
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
                        <h5 class="mb-0">Insetion Formule de composition d'un Voyage</h5>
                    </div>
                    <div class="card-body">
                        <form action="VoyageServelet" method="post">
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Durée</label>
                                <select id="defaultSelect" class="form-select" name="duree">
                                <%  
                                    Vector<Duree> listesDuree =(Vector<Duree>) request.getAttribute("listeDuree");
                                    for (Duree duree : listesDuree) {
                                %>
                                    <option value="<%= duree.getId()%>"><%= duree.getNom()%></option>
                                <% } %>
                                </select>
                            </div>
                                
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Catégorie lieu</label>
                                <select id="defaultSelect" class="form-select" name="categorie">
                                <%  
                                    Vector<Categorie> listesCategorie =(Vector<Categorie>) request.getAttribute("listeCategorie");
                                    for (Categorie categorie : listesCategorie) {
                                %>
                                    <option value="<%= categorie.getIdCategorie()%>"><%= categorie.getNomCategorie()%></option>
                                <% } %>
                                </select>
                            </div>
                                
                            <div class="mb-3">
                                <label for="defaultSelect" class="form-label">Bouquet</label>
                                <select id="selectBouquet" class="form-select" name="bouquet">
                                    <option value="">Selectionner un bouquet</option>
                                <%  
                                    Vector<Bouquet> listesBouquet =(Vector<Bouquet>) request.getAttribute("listeBouquet");
                                    for (Bouquet bouquet : listesBouquet) {
                                %>
                                    <option value="<%= bouquet.getIdBouquet() %>"><%= bouquet.getNomBouquet() %></option>
                                <% } %>
                                </select>
                            </div>
                                
                                <div class="mb-3" id="ChampListActivite">
                                    
                                </div>
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
   var selectBouquet = document.getElementById('selectBouquet');

    selectBouquet.addEventListener('change', function(e){
        var xhr;
        try {
            xhr = new ActiveXObject('Msxml2.XMLHTTP');
        } catch (e) {
            try {
                xhr = new ActiveXObject('Microsoft.XMLHTTP');
            } catch (e2) {
                try {
                    xhr = new XMLHttpRequest();
                } catch (e3) {
                    xhr = false;
                }
            }
        }

        xhr.addEventListener("load", function(event) {
            if (xhr.status === 200) {
                const jsonReponse = JSON.parse(xhr.responseText);
                console.log(jsonReponse);
                var ChampListActivite = document.getElementById('ChampListActivite');
                ChampListActivite.textContent = "";
            for (let i = 0; i < jsonReponse.length; i++) {
                        var label = document.createElement('label');
                        label.textContent = jsonReponse[i].Activite;
                        
                        var input = document.createElement('input');
                        input.type = "number";
                        input.name = "nbActivite";
                        input.className = "form-control";
                        input.id = "html5-date-input";
                       
                        var inputHidden = document.createElement('input');
                        inputHidden.type = "hidden";
                        inputHidden.name = "idActivite";
                        inputHidden.value = jsonReponse[i].idActivite;
                        
                        var div = document.createElement('div');
                        
                        div.appendChild(label);
                        div.appendChild(inputHidden);
                        div.appendChild(input);
                        
                        ChampListActivite.appendChild(div);
               }
            }
            else{
                alert("Erreur!!. Code d'erreur: "+ xhr.status)
            }
        });

		xhr.addEventListener("error", function(event) {
			alert('Oups! Quelque chose s\'est mal passé.');
		});

        xhr.open("GET","InsertFormuleVoyage?idBouquet="+selectBouquet.value);
        xhr.send(null);
    })
</script>                    


