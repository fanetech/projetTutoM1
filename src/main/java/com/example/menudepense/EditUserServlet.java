package com.example.menudepense;

import com.example.menudepense.models.MvmtCaisse;
import com.example.menudepense.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "EditUserServletServlet", value = "/edit-user-servlet/*")
public class EditUserServlet extends HttpServlet {
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

        int id;
        try {
            id = Integer.parseInt(pathParts[1]);
            Database db = new Database();
            ResultSet res =  db.update("SELECT * FROM user WHERE id = '"+id+"'");
            if(res!=null){
                if(res.next()){
                    User mvm = new User();
                    mvm.setId(res.getInt("id"));
                    mvm.setNom(res.getString("nom"));
                    mvm.setPrenom(res.getString("prenom"));
                    mvm.setTel(res.getString("tel"));
                    mvm.setPassword(res.getString("password"));
                    mvm.setUsername(res.getString("username"));
                    mvm.setEmail(res.getString("email"));
                    mvm.setCreatedAt(res.getDate("createdAt"));
                    request.setAttribute("user", mvm);
                    getServletContext().getRequestDispatcher("/editUser.jsp").forward(request, response);
                }

            }else{
                getServletContext().getRequestDispatcher("/editUser.jsp/"+id).forward(request, response);
            }
        } catch (NumberFormatException | SQLException | ServletException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
            return;
        }
    }

    public void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        Database db = new Database();
        int res =  db.insert("UPDATE user SET nom = '"+nom+"', prenom = '"+prenom+"', tel = '"+tel+"', password = '"+password+"', username = '"+username+"', email = '"+email+"'   WHERE id ='"+id+"' ");
        if(res!=0){
            response.sendRedirect("/employe-servlet");
        }else{
            response.sendRedirect("/edit-user-servlet/"+id);
        }
    }

    public void destroy() {
    }
}