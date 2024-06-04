<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un utilisateur</title>
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
<%
    // Retrieve the Mvm object from the request attribute
    User mvm = (User) request.getAttribute("user");

    if (mvm != null) {
        // Use the Mvm object data
%>

<div class="form-container">
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
</body>
</html>
