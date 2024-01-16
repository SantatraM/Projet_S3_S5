<%-- 
    Document   : error
    Created on : 16 janv. 2024, 09:07:34
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
<%@ include file="header.jsp" %>
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
</div>