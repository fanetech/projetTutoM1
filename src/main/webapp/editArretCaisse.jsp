<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.ArretCaisse" %>
<%@ page import="com.example.menudepense.models.DecompoMoney" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un arret de caisse</title>
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
    ArretCaisse mvm = (ArretCaisse) request.getAttribute("mvm");
//    System.out.println(mvm);
//    DecompoMoney decom = (DecompoMoney) request.getAttribute("decom");

    if (mvm != null ) {
        // Use the Mvm object data
%>

<div class="form-container">
    <h1>Modifier un arret de caisse</h1>
    <form method="post" action="/EditArretCaisse-servlet/<%= mvm.getId() %>">
        <div class="form-group">
            <label for="montant">montant</label>
            <input id="montant" type="text" name="montant" required value="<%= mvm.getMoment() %>">
        </div>
        <div class="form-group">
            <label for="commentaire">Commentaire</label>
            <input id="commentaire" type="text" name="commentaire" required value="<%= mvm.getCommentaire() %>">
        </div>

        <div class="form-actions">
            <input class="button" type="submit" value="Enregistrer"/>
        </div>
    </form>
</div>
<%
} else {
%>
<p>No data available.</p>
<%
    }
%>

</body>
</html>