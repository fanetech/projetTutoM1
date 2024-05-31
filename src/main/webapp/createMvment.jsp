<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un mouvement de caisse</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
        }
        .form-container h1 {
            margin-bottom: 20px;
            font-size: 24px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input,
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }
        .form-group textarea {
            resize: vertical;
        }
        .form-group select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background: url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/svgs/solid/caret-down.svg') no-repeat right 10px center;
            background-size: 16px 16px;
        }
        .form-group select option {
            padding: 10px;
        }
        .form-actions {
            text-align: center;
        }
        .form-actions .button {
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .form-actions .button:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
        }
        @media (max-width: 600px) {
            .form-container {
                padding: 10px;
            }
            .form-group label,
            .form-group input,
            .form-group select,
            .form-group textarea,
            .form-actions .button {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Ajouter un mouvement de Caisse</h1>
    <form method="post" action="/servlet-CreateMvment">
        <div class="form-group">
            <label for="libelle">Libellé</label>
            <input type="text" id="libelle" name="libelle" required>
        </div>
        <div class="form-group">
            <label for="commentaire">Commentaire</label>
            <textarea id="commentaire" name="commentaire" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="montant">Montant</label>
            <input type="number" id="montant" name="montant" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="sortie">Sortie</label>
            <select id="sortie" name="type" required>
                <option value="entre">Entre</option>
                <option value="sortie" selected>Sortie</option>
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
    </form>
</div>
</body>
</html>
