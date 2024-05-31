<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.MvmtCaisse" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
<h1>Edit User</h1>
<form action="updateUser" method="post">
    <div>
        <label for="name">Name:</label>
        <input  type="text" id="name" name="name" value="${mvm.}" required />
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required />
    </div>
    <div>
        <button type="submit">Update User</button>
    </div>
</form>
</body>
</html>
