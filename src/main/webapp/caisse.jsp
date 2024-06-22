<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.MvmtCaisse" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <div class="flex flex-row justify-center w-100">
        <div class="content my-8 mx-3">
            <div
                    class="flex h-fit w-full items-center justify-between rounded-t-2xl bg-white px-4 pb-[20px] pt-4 shadow-2xl shadow-gray-100 dark:!bg-navy-700 dark:shadow-none"
            >
                <h4 class="text-lg font-bold text-navy-700 dark:text-white">
                   Mouvement de caisse
                </h4>
                <div>
                    <a href="/export-servlet/caisse">
                        <button
                                class="linear rounded-[20px] bg-lightPrimary px-4 py-2 text-base font-medium text-brand-500 transition duration-200 hover:bg-gray-100 active:bg-gray-200 dark:bg-white/5 dark:text-white dark:hover:bg-white/10 dark:active:bg-white/20"
                        >
                            Export
                        </button>
                    </a>
                    <a href="/servlet-CreateMvment">
                        <button
                                class="linear rounded-[20px] bg-lightPrimary px-4 py-2 text-base font-medium text-brand-500 transition duration-200 hover:bg-gray-100 active:bg-gray-200 dark:bg-white/5 dark:text-white dark:hover:bg-white/10 dark:active:bg-white/20"
                        >
                            Ajouter
                        </button>
                    </a>
                </div>

            </div>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>libellé</th>
                    <th>montant</th>
                    <th>commentaire</th>
                    <th>type</th>
                    <th>date</th>
                    <th>Action</th>
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
                    <td><%= mvmtCaisse.getType() %></td>
                    <td><%= mvmtCaisse.getCreatedAt() %></td>
                    <td class="py-3 text-sm flex flex-column justify-content-center" role="cell">
                        <a href="/EditMvmentServlet-servlet/<%= mvmtCaisse.getId() %>" class="mr-1" >
                            <button class="flex p-1.5 bg-yellow-500 rounded-xl hover:rounded-3xl hover:bg-yellow-600 transition-all duration-300 text-white">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z" />
                                </svg>
                            </button>
                        </a>
                        <a href="/delete-servlet/caisse-mvment/<%= mvmtCaisse.getId() %>"  class="me-1">
                            <button class="flex p-1.5 bg-red-500 rounded-xl hover:rounded-3xl hover:bg-yellow-600 transition-all duration-300 text-white">
                                <svg viewBox="0 0 24 24" width="16" height="16" xmlns="http://www.w3.org/2000/svg" fill="currentColor">
                                    <path d="M9 3V4H4V6H5V20C5 21.1 5.9 22 7 22H17C18.1 22 19 21.1 19 20V6H20V4H15V3H9ZM7 6H17V20H7V6ZM9 8V18H11V8H9ZM13 8V18H15V8H13Z" />
                                </svg>
                            </button>
                        </a>
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
    </div>

</main>
<%@ include file="script.jsp"%>
</body>
</html>
