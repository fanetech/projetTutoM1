package com.example.menudepense;

import com.example.menudepense.models.MvmtCaisse;

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

@WebServlet(name = "EditMvmentServletServlet", value = "/EditMvmentServlet-servlet/*")
public class EditMvmentServlet extends HttpServlet {
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
            System.out.println(id);
            Database db = new Database();
            ResultSet res =  db.update("SELECT * FROM mvment_caisse WHERE id = '"+id+"'");
            if(res!=null){
                if(res.next()){
                    MvmtCaisse mvm = new MvmtCaisse();
                    mvm.setId(res.getInt("id"));
                    mvm.setMontant(res.getInt("montant"));
                    mvm.setCommentaire(res.getString("commentaire"));
                    mvm.setLibelle(res.getString("libelle"));
                    mvm.setCreatedAt(res.getDate("createdAt"));
                    request.setAttribute("mvm", mvm);
                    getServletContext().getRequestDispatcher("/editMvment.jsp").forward(request, response);
                }

            }else{
                getServletContext().getRequestDispatcher("/editMvment.jsp/"+id).forward(request, response);
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
        System.out.println(id);
        System.out.println("Inside doPost method");
        String libelle = request.getParameter("libelle");
        String commentaire = request.getParameter("commentaire");
        String montant = request.getParameter("montant");
        String type = request.getParameter("type");
        String caisse = request.getParameter("caisse");
        Database db = new Database();
        int res =  db.insert("UPDATE users SET libelle = '"+libelle+"', commentaire = '"+commentaire+"', montant = '"+montant+"', type = '"+type+"', caisse = '"+caisse+"'  WHERE id ='"+id+"' ");
        if(res!=0){
            response.sendRedirect("/Caisse-servlet");
        }else{
            getServletContext().getRequestDispatcher("/editMvment.jsp/"+id).forward(request, response);
        }
    }
    public void destroy() {
    }
}