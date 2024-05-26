<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
</head>
<body>
	<div class="surface-ground mb-3 flex align-items-center justify-content-center overflow-hidden">
 		<img
                src="./assets/image/user1.png"
                alt="Caisse App"
                class="mb-3 w-10rem flex-shrink-0"
        />
<div class="container-fluid h-7rem p-4" style="background-color: #f5f7fa;">
    <div class="flex pt-4 px-3 gap-2 ">
        <a href="AddUserServlet" class="btn p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                style="background-color: #425DAE;">
            <span class="font-medium text-gray-900 w-5rem white-space-nowrap" style=" color: white !important;">Ajouter</span>
        </a>
        <a href="" type="button" class="btn float-left p-2 "
           style="background-color: #425DAE;color: white;">
            <i class="bi bi-download" aria-hidden="true"></i>
            <span class="font-medium text-gray-900 w-5rem white-space-nowrap" style=" color: white !important;">Telecharger</span>
        </a>
    </div>
</div>
<section class="intro mt-1 p-1">
    <div class="bg-image " >
        <div class="mask d-flex align-items-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body p-1">
                                <div class="table-responsive table-scroll" data-mdb-perfect-scrollbar="true" style="position: relative;">
                                    <table class="table table-striped mb-0">
                                        <thead style="background-color: #425DAE; color: white;">
                                        <tr>
                                            <th scope="col">Login</th>
                                            <th scope="col">Nom</th>
                                            <th scope="col">Prenom</th>
                                            <th scope="col">Telephone</th>
                                            <th scope="col" style="text-align: center;">Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>
</body>
</html>