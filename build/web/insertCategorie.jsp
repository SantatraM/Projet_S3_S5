<%-- 
    Document   : insertBouquet
    Created on : 12 déc. 2023, 15:33:41
    Author     : hp
--%>

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
                      <h5 class="mb-0">Ajout Categorie lieu</h5>
                    </div>
                    <div class="card-body">
                        <form action="CategorieServelet" method="post" data-parsley-validate="">
                            <input type="hidden" value="1" name="nombreCategorie" id="inputHidden">
                            <div class="mb-3" id="form">
                                <label for="exampleFormControlSelect1" class="form-label">Entrez un categorie lieu</label>
                                <div class="col-md-10">
                                    <input class="form-control" type="text"  id="html5-date-input" name="categorie1" required=""/>
                                </div>
                                <div class="navbar-nav align-items-center">
                                    <div class="nav-item d-flex align-items-center">
                                        <span id="plus"><label for="exampleFormControlSelect1" class="form-label"><button type="button" onclick="autreCategorie()" >+</button></label></span>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Generer</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    window.onbeforeunload = function() {
            localStorage.setItem('Categorie',1);
    };

    function avoirQuantite(){
        return localStorage.setItem('Categorie');
    }

    function autreCategorie() {
        var numero=localStorage.getItem('Categorie');
        var nombreArticle=parseInt(numero)+1;
        var conteneurForm= document.getElementById("form");
        var div=document.createElement("div");
        var nouveau = '<div class="col-md-10"><input class="form-control" type="text"  id="html5-date-input" name=categorie'+nombreArticle+' required=""/></div><div class="navbar-nav align-items-center"> <div class="nav-item d-flex align-items-center"><span id="plus"><label for="exampleFormControlSelect1" class="form-label"><button type="button" onclick="nombreArticle=autreCategorie()">+</button></label></span> </div></div>';
        div.innerHTML = nouveau;
        conteneurForm.appendChild(div);
        localStorage.setItem('Categorie',nombreArticle)
        var hidden=document.getElementById("inputHidden");
        hidden.value=nombreArticle;
        var span = document.getElementById("plus");
        span.remove();
    }
</script>