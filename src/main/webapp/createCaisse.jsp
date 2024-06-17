<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <div class="flex flex-row justify-center w-100">
        <div class="form-container my-8 ml-3">
            <h1>Ajouter une caisse</h1>
            <form method="post" action="/CreateCaisse-servlet">
                <div class="form-group">
                    <label for="libelle">Libellé</label>
                    <input type="text" id="libelle" name="libelle" required>
                </div>
                <div class="form-group">
                    <label for="montant">Montant</label>
                    <input type="number" id="montant" name="montant" step="0.01" required>
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
