<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.menudepense.models.User" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="sidebar.jsp"%>
<main class="w-full md:w-[calc(100%-256px)] md:ml-64 bg-gray-200 min-h-screen transition-all main">
    <%@ include file="navbar.jsp"%>
    <div class="p-6">
        <a href="/Logout-servlet" role="menuitem" class="flex items-center text-[13px] py-1.5 px-4 text-gray-600 hover:text-[#f84525] hover:bg-gray-50 cursor-pointer"
         >
            Deconnexion
        </a>
                <div class="flex flex-col justify-center items-center h-[100vh]">
                    <div
                            class="relative flex max-w-[800px] h-[430px] w-full flex-col rounded-[10px] border-[1px] border-gray-200 bg-white bg-clip-border shadow-md shadow-[#F3F3F3] dark:border-[#ffffff33] dark:!bg-navy-800 dark:text-white dark:shadow-none"
                    >
                        <div
                                class="flex h-fit w-full items-center justify-between rounded-t-2xl bg-white px-4 pb-[20px] pt-4 shadow-2xl shadow-gray-100 dark:!bg-navy-700 dark:shadow-none"
                        >
                            <h4 class="text-lg font-bold text-navy-700 dark:text-white">
                                Utilisateurs
                            </h4>
                            <a href="/CreateUser-servlet"  >
                                <button
                                        class="linear rounded-[20px] bg-lightPrimary px-4 py-2 text-base font-medium text-brand-500 transition duration-200 hover:bg-gray-100 active:bg-gray-200 dark:bg-white/5 dark:text-white dark:hover:bg-white/10 dark:active:bg-white/20"
                                >
                                    Ajouter
                                </button>
                            </a>

                        </div>
                        <div class="w-full overflow-x-scroll px-4">
                            <table role="table" class="w-full min-w-[500px] overflow-x-scroll">
                                <thead>
                                <tr role="row">
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            Nom
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            Prenom
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            téléphone
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            username
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            Email
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            Role
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            Date
                                        </div>
                                    </th>
                                    <th
                                            colspan="1"
                                            role="columnheader"
                                            title="Toggle SortBy"
                                            style="cursor: pointer"
                                    >
                                        <div
                                                class="flex items-center justify-between pb-2 pt-4 text-start uppercase tracking-wide text-write-600 sm:text-xs lg:text-xs"
                                        >
                                            Action
                                        </div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody role="rowgroup" class="px-4">
                                <%
                                    List<User> users = (List<User>) request.getAttribute("users");
                                    if (users != null) {
                                        for (User user : users) {
                                %>

                                <tr role="row">
                                    <td class="py-3 text-sm" role="cell">
                                        <div class="flex items-center gap-2">
                                            <div class="h-[30px] w-[30px] rounded-full">
                                                <img
                                                        src="https://images.unsplash.com/photo-1506863530036-1efeddceb993?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=2244&amp;q=80"
                                                        class="h-full w-full rounded-full"
                                                        alt=""
                                                />
                                            </div>
                                            <p
                                                    class="text-sm font-medium text-navy-700 dark:text-white"
                                            >
                                                <%= user.getNom() %>
                                            </p>
                                        </div>
                                    </td>
                                    <td class="py-3 text-sm" role="cell">
                                        <p class="text-md font-medium text-gray-600 dark:text-white">
                                            <%= user.getPrenom() %>
                                        </p>
                                    </td>
                                    <td class="py-3 text-sm" role="cell">
                                        <p class="text-md font-medium text-gray-600 dark:text-white">
                                            <%= user.getTel() %>
                                        </p>
                                    </td>
                                    <td class="py-3 text-sm" role="cell">
                                        <p class="text-md font-medium text-gray-600 dark:text-white">
                                            <%= user.getUsername() %>
                                        </p>
                                    </td>
                                    <td class="py-3 text-sm" role="cell">
                                        <p class="text-md font-medium text-gray-600 dark:text-white">
                                            <%= user.getEmail() %>
                                        </p>
                                    </td>
                                    <td class="py-3 text-sm" role="cell">
                                        <p class="text-md font-medium text-gray-600 dark:text-white">
                                            <%= user.getRole() %>
                                        </p>
                                    </td>
                                    <td class="py-3 text-sm" role="cell">
                                        <p class="text-md font-medium text-gray-600 dark:text-white">
                                            <%= user.getCreatedAt() %>
                                        </p>
                                    </td>
                                    <td class="py-3 text-sm flex flex-column justify-content-center" role="cell">
                                        <a href="/edit-user-servlet/<%= user.getId() %>" class="mr-1" >
                                            <button class="flex p-1.5 bg-yellow-500 rounded-xl hover:rounded-3xl hover:bg-yellow-600 transition-all duration-300 text-white">
                                                <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                                    <path stroke-linecap="round" stroke-linejoin="round" d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z" />
                                                </svg>
                                            </button>
                                        </a>
                                        <a href="/delete-servlet/user/<%= user.getId() %>"  class="me-1">
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
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

    </div>

</main>

<%@ include file="script.jsp"%>
</body>
</html>
