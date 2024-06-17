package com.example.menudepense;

import com.example.menudepense.models.Caisse;
import com.example.menudepense.models.MvmtCaisse;
import com.example.menudepense.models.User;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditCaisseServletServlet", value = "/editCaisse-servlet/*")
public class EditCaisseServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            ResultSet res =  db.update("SELECT * FROM caisse WHERE id = '"+id+"'");
            if(res!=null){
                if(res.next()){
                    Caisse mvm = new Caisse();
                    mvm.setId(res.getInt("id"));
                    mvm.setMoment(res.getInt("montant"));
                    mvm.setLibelle(res.getString("libelle"));
                    request.setAttribute("mvm", mvm);
                    getServletContext().getRequestDispatcher("/editCaisse.jsp").forward(request, response);
                }

            }else{
                response.sendRedirect("/caisseMain-servlet");
            }
        } catch (NumberFormatException | SQLException e) {
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
        String libelle = request.getParameter("libelle");
        Integer montant = Integer.parseInt(request.getParameter("montant")) ;
        Database db = new Database();
        int res =  db.insert("UPDATE caisse SET libelle = '"+libelle+"', montant = '"+montant+"' WHERE id ='"+id+"' ");
        if(res!=0){
            response.sendRedirect("/caisseMain-servlet");
        }else{
            response.sendRedirect("/editCaisse-servlet/"+id);
        }
    }


    public void destroy() {
    }
}