<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Login & Signup Form</title>
    <style>
    	<%@ include file="loginCss.css"%>
     </style>
</head>
<body>
<section class="wrapper">
    	<pre>${dbmsOutput}</pre>
    	
    	<div class="form login">
        <header>Se connecter</header>
        <form action="/login" method="post">
          <input type="text" name="username" placeholder="Username" required />
          <input type="password" name="password" placeholder="Mot de passe" required />
          <a href="#">Mot de passe oublier?</a>
          <input type="submit" value="Se connecter" />
        </form>
      </div>
      <div class="form signup">
        <header>S'inscrire</header>
        <form action="../addUser" method="post">
          <input type="text" name="nom" placeholder="Nom" required />
          <input type="email" name="email" placeholder="Adresse Email" required />
          <input type="password" name="password" placeholder="Mot de passe" required />
          <div class="checkbox">
            <input type="checkbox" id="signupCheck" />
            <label for="signupCheck">j'accecpte tout les termes & conditions</label>
          </div>
          <input type="submit" value="S'enregistrer" />
        </form>
      </div>
      <p>${errorMessage}</p>
      
      <script>
        const wrapper = document.querySelector(".wrapper"),
          signupHeader = document.querySelector(".signup header"),
          loginHeader = document.querySelector(".login header");
        
        loginHeader.addEventListener("click", () => {
          wrapper.classList.add("active");
        });
        signupHeader.addEventListener("click", () => {
          wrapper.classList.remove("active");
        });
      </script>
    </section>
</body>
</html>