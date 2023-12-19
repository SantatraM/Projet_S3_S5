<%-- 
    Document   : insertActivity
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
                      <h5 class="mb-0">Ajout Activite</h5>
                    </div>
                    <div class="card-body">
                        <form action="ActiviteServelet" method="post">
                            <input type="hidden" value="1" name="nombreActivite" id="inputHidden">
                            <div class="mb-3" id="form">
                                <label for="exampleFormControlSelect1" class="form-label">Entrez une activite</label>
                                <div class="col-md-10">
                                    <input class="form-control" type="text"  id="html5-date-input" name="activite1" required/>
                                </div>
                                <div class="navbar-nav align-items-center">
                                    <div class="nav-item d-flex align-items-center">
                                        <span id="plus"><label for="exampleFormControlSelect1" class="form-label"><button type="button" onclick="autreArticle()" >+</button></label></span>
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
        localStorage.setItem('Activite',1);
    };

    function avoirQuantite(){
        return localStorage.setItem('Activite');
    }

    function autreArticle() {
        var numero=localStorage.getItem('Activite');
        var nombreArticle=parseInt(numero)+1;
        var conteneurForm= document.getElementById("form");
        var div=document.createElement("div");
        var nouveau = '<div class="col-md-10"><input class="form-control" type="text"  id="html5-date-input" name=activite'+nombreArticle+' required/></div><div class="navbar-nav align-items-center"> <div class="nav-item d-flex align-items-center"><span id="plus"><label for="exampleFormControlSelect1" class="form-label"><button type="button" onclick="nombreArticle=autreArticle()">+</button></label></span> </div></div>';
        div.innerHTML = nouveau;
        conteneurForm.appendChild(div);
        localStorage.setItem('Activite',nombreArticle)
        var hidden=document.getElementById("inputHidden");
        hidden.value=nombreArticle;
        var span = document.getElementById("plus");
        span.remove();
    }
</script>