<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.menudepense.models.Caisse" %>
<%@ page import="java.util.List" %>
<%
    // Retrieve session attributes
   List<Caisse> caisses = (List<Caisse>) session.getAttribute("caisses");
%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <div class="flex flex-row justify-center w-100">
        <div class="form-container mt-8 ml-3">
            <h1>Ajouter un utilisateur</h1>
            <form method="post" action="/CreateUser-servlet">
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input id="nom" type="text" name="nom" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Nom</label>
                    <input id="prenom" type="text" name="prenom" required>
                </div>
                <div class="form-group">
                    <label for="tel">Tel</label>
                    <input type="text" id="tel" name="tel" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" id="password" name="password" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="caisse">Type</label>
                    <select id="caisse" name="caisseId">
                        <%
                                for (Caisse caisse : caisses) {
                                    System.out.println(caisse.toString());
                        %>
                        <option value="<%= caisse.getId() %>"><%= caisse.getLibelle() %></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="form-actions">
                    <input class="button" type="submit" value="Enregistrer"/>
                </div>
            </form>
        </div>
    </div>
</main>
<%@ include file="script.jsp"%>
</body>
</html>
