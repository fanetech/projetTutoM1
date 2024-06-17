<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.ArretCaisse" %>
<%@ page import="com.example.menudepense.models.DecompoMoney" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <div class="flex flex-row justify-center w-100">

        <%
            // Retrieve the Mvm object from the request attribute
            ArretCaisse mvm = (ArretCaisse) request.getAttribute("mvm");
//    System.out.println(mvm);
//    DecompoMoney decom = (DecompoMoney) request.getAttribute("decom");

            if (mvm != null ) {
                // Use the Mvm object data
        %>

        <div class="form-container my-8 mx-3">
            <h1>Modifier un arret de caisse</h1>
            <form method="post" action="/EditArretCaisse-servlet/<%= mvm.getId() %>">
                <div class="form-group">
                    <label for="montant">montant</label>
                    <input id="montant" type="text" name="montant" required value="<%= mvm.getMoment() %>">
                </div>
                <div class="form-group">
                    <label for="commentaire">Commentaire</label>
                    <input id="commentaire" type="text" name="commentaire" required value="<%= mvm.getCommentaire() %>">
                </div>

                <div class="form-actions">
                    <input class="button" type="submit" value="Enregistrer"/>
                </div>
            </form>
        </div>
        <%
        } else {
        %>
        <p>No data available.</p>
        <%
            }
        %>

    </div>
</main>
<%@ include file="script.jsp"%>
</body>
</html>