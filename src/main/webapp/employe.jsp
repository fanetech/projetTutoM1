<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Formulaire d'enregistrement</title>
<style>
	<%@ include file="../../styles/style.css"%>
</style>

</head>
<body>
	<div class="surface-ground mb-3 flex align-items-center justify-content-center overflow-hidden">
    <div class="flex flex-column align-items-center justify-content-center">
     <img
                src="./assets/image/user.jpg"
                alt="Caisse App"
                class="mb-3 w-10rem flex-shrink-0"
       />
    
    <form method="post" action="AddUserServlet">
        <div class="flex flex-wrap">
            <div class="text-900 text-3xl font-medium text-center mb-3">Gestionnaire</div><br><br>
            
            <div class="col-12">
                <div class="grid">
                    <div class="field col-12 col-md-4">
                        <label class="block text-900 text-xl font-medium mb-2">Nom</label>
                        <input
                                name="nom"
                                type="text"
                                required
                                class="w-full md:w-30rem mb-3 form-control"
                        />
                    </div>

                    <div class="field col-12 col-md-4">
                        <label class="block text-900 text-xl font-medium mb-2">Prenom</label>
                        <input
                                name="prenom"
                                type="text"
                                required
                                class="w-full md:w-30rem mb-3 form-control"
                        />
                    </div>
                    <div class="field col-12 col-md-4">
                        <label class="block text-900 text-xl font-medium mb-2">Telephone</label>
                        <input
                                name="telephone"
                                type="text"
                                required
                                class="w-full md:w-30rem mb-3 form-control"
                        />
                    </div>
                </div>

                <div class="grid">
                    <div class="field col-12 col-md-6">
                        <label class="block text-900 text-xl font-medium mb-2">Login</label>
                        <input
                                name="login"
                                type="text"
                                required
                                class="w-full md:w-30rem mb-3 form-control"
                        />
                    </div>

                    <div class="field col-12 col-md-6">
                        <label class="block text-900 text-xl font-medium mb-2">Password</label>
                        <input
                                name="password"
                                type="password"
                                required
                                class="w-full md:w-30rem mb-3 form-control"
                        />
                    </div>
                </div>
            </div>
        </div>
        <div
                class="flex align-items-center justify-content-center pt-2 px-3 gap-2"
        >
            <button class="btn w-full p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                    style="background-color: #425DAE;border-radius: 10px;height: 3rem; color:white; text-align: center" ><span>Enregistrer</span></button>
            <a href="" class="btn w-full p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                    style="background-color: #d9342b;border-radius: 10px;height: 3rem; color:white; text-align: center" ><span>Annuler</span></a>
        </div>
    </form>
    </div>
</div>
</body>
</html>