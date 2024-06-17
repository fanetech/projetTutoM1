<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu-caisse</title>
<style>
      <%@ include file="style.css"%>
  </style>
</head>
<body>
	<div class="mb-3">
    <div class="flex flex-column align-items-center justify-content-center">
        <img
                src="./assets/images/caisse.png"
                alt="Caisse App"
                class="mb-3 w-10rem flex-shrink-0"
        />
        
        <form method="post" action="">
            <div>
                <div class="w-full surface-card" style="border-radius: 53px">
                    <div class="text-900 text-3xl font-medium text-center mb-3">FORMULAIRE CONNEXION</div>
                    <div>

                        <form action="/login" method="post">
                            <label class="block text-900 text-xl font-medium mb-2">Login</label>
                            <input
                                    type="text"
                                    name="username"
                                    class="w-full md:w-30rem mb-3 form-control"
                                    style="padding: 1rem"
                                    required
                            />
                            <label class="block text-900 font-medium text-xl mb-2"
                            >Mot de passe</label
                            >
                            <input
                                    type="password"
                                    name="password"
                                    class="w-full md:w-30rem mb-3 form-control"
                                    style="padding: 1rem"
                                    required
                            />
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