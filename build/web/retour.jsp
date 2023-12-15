<%-- 
    Document   : retour
    Created on : 15 déc. 2023, 10:51:15
    Author     : hp
--%>

<style>
    #erreur{
        width:1000px;
        margin-left:auto;
        margin-right:auto;
        float:right;
        backgroundcolor:red;
    }
    #messageErreur{
        color:red;
    }
</style>
<%@ include file="index.html" %>
<div class="row" id="erreur">
    <div class="col-12">
        <div class="card mb-4">
            <h5 class="card-header">!Erreur!</h5>
            <div class="card-body">
                <p class="card-text" id="messageErreur" >
                    <%= request.getAttribute("erreur") %>
                </p>
            </div>
        </div>
    </div>
    <div class="mb-3" style="width: 20%">
        <button class="btn btn-primary d-grid w-100"><a href="BouquetActivite" style="color: black">Inserer activites</a></button>
    </div>

</div>
                
