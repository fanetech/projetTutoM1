<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
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
            text-transform: uppercase;
            letter-spacing: 2px;
        }
        .content {
            margin-top: 140px; /* Adjusted margin-top to give more space */
            width: 100%;
            max-width: 1200px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .add-button {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: #28a745;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.3s;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .add-button:hover {
            background-color: #218838;
            transform: translateY(-2px);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
            text-transform: uppercase;
            font-size: 14px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e9ecef;
        }
        .action-button {
            padding: 8px 12px;
            font-size: 14px;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.3s;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-right: 5px;
        }
        .edit-button {
            background-color: #007bff;
        }
        .edit-button:hover {
            background-color: #0056b3;
            transform: translateY(-1px);
        }
        .delete-button {
            background-color: #dc3545;
        }
        .delete-button:hover {
            background-color: #c82333;
            transform: translateY(-1px);
        }
        .action-buttons {
            display: flex;
            gap: 5px;
        }
        .menu {
            display: flex;
            gap: 15px;
            background-color: #28a745; /* Changed to green */
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            position: fixed;
            top: 20px;
            right: 20px;
            z-index: 1000;
        }
        .menu a {
            color: white;
            text-decoration: none;
            padding: 10px;
            transition: background-color 0.3s;
        }
        .menu a:hover {
            background-color: #495057;
        }
    </style>
</head>
<body>
<header>
    <h1>Liste des utilisateurs</h1>
</header>
<div class="menu">
    <a href="caisse.jsp">Journal de caisse</a>
    <a href="mouve_interface.jsp">Mouvement de compte</a>
    <a href="utilisateur.jsp">Employé</a>
    <a href="utilisateur.jsp">Arrêt de caisse</a>
</div>
<div class="content">
    <a href="/CreateUser-servlet"  class="add-button"><i class="fas fa-plus"></i> Ajouter</a>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>téléphone</th>
            <th>username</th>
            <th>Email</th>
            <th>Role</th>
            <th>Date creation</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null) {
                for (User user : users) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getNom() %></td>
            <td><%= user.getPrenom() %></td>
            <td><%= user.getTel() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getRole() %></td>
            <td><%= user.getCreatedAt() %></td>
            <td class="action-buttons">
                <a href="/edit-user-servlet/<%= user.getId() %>" class="action-button edit-button"><i class="fas fa-edit"></i> Modifier</a>
                <a href="/delete-servlet/user/<%= user.getId() %>" class="action-button delete-button"><i class="fas fa-trash"></i> Supprimer</a>
            </td>
        </tr>

        <%
                }
            } else {
                System.out.println("<tr><td colspan='3'>No users found</td></tr>");
            }
        %>
        <!-- Ajoutez d'autres lignes ici -->
        </tbody>
    </table>
</div>
</body>
</html>
