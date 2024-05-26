<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestionnaire</title>
</head>
<body>
	<%-- <%@ include file="../../assets/components/navbar.jsp"%>--%>
<div class="surface-ground mt-3 flex align-items-center justify-content-center overflow-hidden">
    <div class="flex flex-column align-items-center justify-content-center">
    <%--     <%
            String login = request.getParameter("login");
            UserDao userDao = new UserDao();
            Gestionnaire user = userDao.findByLogin(login);
        %>
        --%>
        
        <form method="post" action="UpdateUserServlet">
            <div class="flex flex-wrap">
                <div class="text-900 text-3xl font-medium text-center mb-3">FORMULAIRE</div>
                
                <div class="col-12">
                    <div class="grid">
                        <div class="field col-12 col-md-6">
                            <label class="block text-900 text-xl font-medium mb-2">Nom</label>
                            <input
                                    name="nom"
                                    type="text"
                                    required
                                    value=""
                                    class="w-full md:w-30rem mb-3 form-control"
                            />
                        </div>

                        <div class="field col-12 col-md-6">
                            <label class="block text-900 text-xl font-medium mb-2">Prenom</label>
                            <input
                                    name="prenom"
                                    type="text"
                                    required
                                    value=""
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
                                    value=""
                                    class="w-full md:w-30rem mb-3 form-control"
                            />
                        </div>

                        <div class="field col-12 col-md-6">
                            <label class="block text-900 text-xl font-medium mb-2">Telephone</label>
                            <input
                                    name="telephone"
                                    type="text"
                                    required
                                    value=""
                                    class=""
                            />
                        </div>
                    </div>
                </div>
            </div>
            <div
                    "
            >
                <button class="btn w-full p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                        style="background-color: #425DAE;border-radius: 10px;height: 3rem; color:white; text-align: center" ><span>Enregistrer</span></button>
                <a href="" class="btn w-full p-2 flex gap-2 border-1 shadow-1 cursor-pointer "
                   style="background-color: black;border-radius: 10px;height: 3rem; color:white; text-align: center" ><span>Annuler</span></a>
            </div>
        </form>
    </div>
</div>
</body>
</html>