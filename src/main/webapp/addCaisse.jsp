<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	<%@ include file="../../styles/style.css"%>
</style>
</head>
<body>
	<body>

<div class="surface-ground mt-3 flex align-items-center justify-content-center overflow-hidden">
    <div class="flex flex-column align-items-center justify-content-center">
        <img
                src="./assets/image/caisse.jpg"
                alt="Caisse App"
                class="mb-3 w-10rem flex-shrink-0"
        />
        <form method="post" action="">
            <div>
                <div class="w-full surface-card" style="border-radius: 53px">
                    <div class="text-900 text-3xl font-medium text-center mb-3">FORMULAIRE AJOUT CAISSE</div>
                    
                    <div>
                        <label class="block text-900 text-xl font-medium mb-2">Libelle</label>
                        <input
                                type="text"
                                name="libelle"
                                class="w-full md:w-30rem mb-3 form-control"
                                style="padding: 1rem"
                                required
                        />
                        <div
                                class="flex align-items-center justify-content-center pt-2 px-3 gap-2"
                        >
                            <button class="btn w-full p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                                    style="background-color: #425DAE;border-radius: 10px;height: 3rem; color:white; text-align: center" ><span>Enregistrer</span></button>
                            <a href="" class="btn w-full p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                               style="background-color: #d9342b;border-radius: 10px;height: 3rem; color:white; text-align: center" ><span>Annuler</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>