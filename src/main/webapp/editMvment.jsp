<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.MvmtCaisse" %>
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
            MvmtCaisse mvm = (MvmtCaisse) request.getAttribute("mvm");

            if (mvm != null) {
                // Use the Mvm object data
        %>

        <div class="form-container my-8 ml-3">
            <h1>Modifier un mouvement de caisse</h1>
            <form method="post" action="/EditMvmentServlet-servlet/<%= mvm.getId() %>">

                <div class="form-group">
                    <label for="libelle">Libellé</label>
                    <input type="text" id="libelle" name="libelle" value="<%= mvm.getLibelle() %>" required>
                </div>
                <div class="form-group">
                    <label for="commentaire">Commentaire</label>
                    <textarea id="commentaire" name="commentaire" rows="4" required><%= mvm.getCommentaire() %></textarea>
                </div>
                <div class="form-group">
                    <label for="montant">Montant</label>
                    <input type="number" id="montant" name="montant" step="0.01"  value="<%= mvm.getMontant() %>"required>
                </div>
                <div class="form-group">
                    <label for="sortie">Type</label>
                    <select id="sortie" name="type" required  >
                        <option value="entre" <%= "entre".equals(mvm.getType()) ? "selected" : "" %>>Entre</option>
                        <option value="sortie" <%= "sortie".equals(mvm.getType()) ? "selected" : "" %> >Sortie</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="livreur">Livreur</label>
                    <select id="livreur" name="caisse" required>
                        <option value="1">Fourniseur</option>
                        <option value="2" selected>Livreur</option>
                    </select>
                </div>
                <div class="form-actions">
                    <input class="button" type="submit" value="Enregistrer"/>
                </div>
                <%
                } else {
                %>
                <p>No data available.</p>
                <%
                    }
                %>

            </form>
        </div>
    </div>
</main>
<%@ include file="script.jsp"%>
</body>
</html>
