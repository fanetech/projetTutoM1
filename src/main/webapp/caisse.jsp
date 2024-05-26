<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.MvmtCaisse" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Table</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Journal de caisse</h1>
<a href="/servlet-CreateMvment">creer un mouvement de caisse</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>libellé</th>
        <th>montant</th>
        <th>commentaire</th>
        <th>beneficiaire</th>
        <th>receveur</th>
        <th>type</th>
        <th>date</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<MvmtCaisse> mvmtCaisseList = (List<MvmtCaisse>) request.getAttribute("mvmtCaisseList");
        if (mvmtCaisseList != null) {
            for (MvmtCaisse mvmtCaisse : mvmtCaisseList) {
                %>
    <tr>
        <td><%= mvmtCaisse.getId() %></td>
        <td><%= mvmtCaisse.getLibelle() %></td>
        <td><%= mvmtCaisse.getMontant() %></td>
        <td><%= mvmtCaisse.getCommentaire() %></td>
        <td><%= mvmtCaisse.getBeneficiaire() %></td>
        <td><%= mvmtCaisse.getReceveur() %></td>
        <td><%= mvmtCaisse.getType() %></td>
        <td><%= mvmtCaisse.getCreatedAt() %></td>
    </tr>
    <%
            }
        } else {
            System.out.println("<tr><td colspan='3'>No users found</td></tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
