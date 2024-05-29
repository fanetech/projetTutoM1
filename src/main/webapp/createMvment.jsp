<%--
  Created by IntelliJ IDEA.
  User: AvePlus-Fanetech
  Date: 24/05/2024
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@ include file="./css/style.css"%>
    </style>
</head>
<body>
    <h1>Créer un mouvement de caisse</h1>
    <a href="/Home-servlet">Accueil</a>
    <div class="mb-3">
        <div class="flex flex-column align-items-center justify-content-center">

            <form method="post" action="">
                <div>
                    <div class="w-full surface-card" style="border-radius: 53px">
                        <div class="text-900 text-3xl font-medium text-center mb-3">Remplissez le formulaire suivant</div>
                        <div>

                            <form method="post" action="/servlet-CreateMvment">
                                <label class="block text-900 text-xl font-medium mb-2">Libellé</label>
                                <input
                                        type="text"
                                        name="libelle"
                                        class="w-full md:w-30rem mb-3 form-control"
                                        style="padding: 1rem"
                                        required
                                />
                                <label class="block text-900 font-medium text-xl mb-2"
                                >Commentaire</label
                                >
                                <input
                                        type="text"
                                        name="commentaire"
                                        class="w-full md:w-30rem mb-3 form-control"
                                        style="padding: 1rem"
                                        required
                                />
                                <label class="block text-900 font-medium text-xl mb-2"
                                >Momant</label
                                >
                                <input
                                        type="number"
                                        name="montant"
                                        class="w-full md:w-30rem mb-3 form-control"
                                        style="padding: 1rem"
                                        required
                                />
                                <select name="type">
                                    <option value="entre">Entre</option>
                                    <option value="sortie" selected>Sortie</option>
                                </select>
                                <select name="caisse">
                                    <option value="1">Fourniseur</option>
                                    <option value="2" selected>Livreur</option>
                                </select>
                                <input type="submit" value="S'identifier">
                            </form>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
