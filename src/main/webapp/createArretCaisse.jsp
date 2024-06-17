<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <div class="flex flex-row justify-center w-100">
        <div class="form-container my-8 mx-3">
            <h1>Faire un arrêt de compte</h1>
            <form method="post" action="/createArretCaisse-servlet">
                <div class="form-group">
                    <label for="montant">montant</label>
                    <input id="montant" type="text" name="montant" required>
                </div>
                <div class="form-group">
                    <label for="commentaire">Commentaire</label>
                    <input id="commentaire" type="text" name="commentaire" required>
                </div>
                <div class="form-group">
                    <label for="nb_10000">Nombre 10000 F</label>
                    <input id="nb_10000" type="number" name="nb_10000" required>
                </div>
                <div class="form-group">
                    <label for="nb_5000">Nombre 5000 F</label>
                    <input type="number" id="nb_5000" name="nb_5000" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_2000">Nombre 2000 F</label>
                    <input type="number" id="nb_2000" name="nb_2000" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_1000">Nombre 1000 F</label>
                    <input type="number" id="nb_1000" name="nb_1000" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_500">Nombre 500 F</label>
                    <input type="number" id="nb_500" name="nb_500" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_200">Nombre 200 F</label>
                    <input type="number" id="nb_200" name="nb_200" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_250">Nombre 250 F</label>
                    <input type="number" id="nb_250" name="nb_250" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_100">Nombre 100 F</label>
                    <input type="number" id="nb_100" name="nb_100" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_50">Nombre 50 F</label>
                    <input type="number" id="nb_50" name="nb_50" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_25">Nombre 25 F</label>
                    <input type="number" id="nb_25" name="nb_25" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_10">Nombre 10 F</label>
                    <input type="number" id="nb_10" name="nb_10" step="0.01" required>
                </div>
                <div class="form-group">
                    <label for="nb_5">Nombre 5 F</label>
                    <input type="number" id="nb_5" name="nb_5" step="0.01" required>
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
