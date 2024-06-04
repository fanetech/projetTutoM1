<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page d'accueil</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            position: relative;
            padding-bottom: 60px; /* Footer height */
        }
        header {
            width: 100%;
            background-color: #343a40;
            color: white;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            position: fixed;
            top: 0;
            z-index: 1000;
        }
        header h1 {
            margin: 0;
            font-size: 24px;
        }
        .container {
            margin-top: 100px; /* Height of the header */
            text-align: center;
        }
        .button {
            display: inline-block;
            margin: 15px;
            padding: 15px 30px;
            font-size: 18px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.3s;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .button:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
        }
        .button i {
            margin-right: 10px;
        }
        footer {
            width: 100%;
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: absolute;
            bottom: 0;
        }
    </style>
</head>
<body>
<header>
    <h1>Gestion de caisse</h1>
</header>
<div class="container">
    <a href="/Caisse-servlet" class="button"><i class="fas fa-cash-register"></i>Journal de caisse</a>
    <a href="/servlet-CreateMvment" class="button"><i class="fas fa-exchange-alt"></i>Mouvement de Compte</a>
    <a href="/employe-servlet" class="button"><i class="fas fa-user"></i>Employé</a>
    <a href="arretCaisse.jsp" class="button"><i class="fas fa-times-circle"></i>Arrêt Caisse</a>
</div>
<footer>
    &copy; 2024 Projet java MSI1. Tous droits réservés.
</footer>
</body>
</html>
