<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un utilisateur</title>
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
</body>
</html>
