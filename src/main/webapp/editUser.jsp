<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <%
        // Retrieve the Mvm object from the request attribute
        User mvm = (User) request.getAttribute("user");

        if (mvm != null) {
            // Use the Mvm object data
    %>

    <div class="flex flex-row justify-center w-100">
        <div class="form-container mt-8 ml-3">
            <h1>Modifier un utilisateur</h1>
            <form method="post" action="/edit-user-servlet/<%= mvm.getId() %>">

                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" id="nom" name="nom" value="<%= mvm.getNom() %>" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prenom</label>
                    <input type="text" id="prenom" name="prenom" value="<%= mvm.getPrenom() %>" required>
                </div>
                <div class="form-group">
                    <label for="tel">téléphone</label>
                    <input type="text" id="tel" name="tel" step="0.01"  value="<%= mvm.getTel() %>"required>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" id="password" name="password" step="0.01"  value="<%= mvm.getPassword() %>"required>
                </div>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" step="0.01"  value="<%= mvm.getUsername() %>"required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" step="0.01"  value="<%= mvm.getEmail() %>"required>
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
