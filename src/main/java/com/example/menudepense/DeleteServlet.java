package com.example.menudepense;

import com.example.menudepense.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "DeleteServletServlet", value = "/delete-servlet/*")
public class DeleteServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo(); // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
            return;
        }

        String[] pathParts = pathInfo.split("/");
        if (pathParts.length < 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            return;
        }

        Database db = new Database();
        switch (pathParts[1]){
            case "caisse-mvment":
                int res =  db.delete("DELETE FROM mvment_caisse WHERE id = '"+pathParts[2]+"'");
                if(res!=0){
                    response.sendRedirect("/Caisse-servlet");
                }else{
                    response.sendRedirect("/Caisse-servlet");
                }
                break;
            case "user":
                int userRes =  db.delete("DELETE FROM user WHERE id = '"+pathParts[2]+"'");
                if(userRes!=0){
                    response.sendRedirect("/employe-servlet");
                }else{
                    response.sendRedirect("/employe-servlet");
                }
                break;
            case "arret-caisse":
                int userAc =  db.delete("DELETE FROM arret_caisse WHERE id = '"+pathParts[2]+"'");
                System.out.println(userAc);
                if(userAc!=0){
                    response.sendRedirect("/arretCaisse-servlet");
                }else{
                    response.sendRedirect("/arretCaisse-servlet");
                }
                break;
            case "caisse":
                int userCaisse =  db.delete("DELETE FROM caisse WHERE id = '"+pathParts[2]+"'");
                System.out.println(userCaisse);
                if(userCaisse!=0){
                    response.sendRedirect("/caisseMain-servlet");
                }else{
                    response.sendRedirect("/caisseMain-servlet");
                }
                break;
            default:
                response.sendRedirect("/");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
            return;
        }

        String[] pathParts = pathInfo.split("/");
        if (pathParts.length < 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            return;
        }

        int id;
        id = Integer.parseInt(pathParts[1]);
        System.out.println(id);
        System.out.println(pathParts);
//        Database db = new Database();
//        int res =  db.delete("DELETE FROM your_table WHERE id = '"+id+"'");
//        if(res!=0){
//            response.sendRedirect("/Caisse-servlet");
//        }else{
//            response.sendRedirect("/Caisse-servlet");
//        }
    }

    public void destroy() {
    }
}