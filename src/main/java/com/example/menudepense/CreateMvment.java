package com.example.menudepense;


import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateMvmentServlet", value = "/servlet-CreateMvment")
public class CreateMvment extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/createMvment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside doPost method");
        String libelle = request.getParameter("libelle");
        String commentaire = request.getParameter("commentaire");
        String montant = request.getParameter("montant");
        String type = request.getParameter("type");
        String caisse = request.getParameter("caisse");
        LocalDate currentDate = LocalDate.now();
        Database db = new Database();
        System.out.println("INSERT INTO mvment_caisse (id_caisse, id_caisse_mvmt, id_user, libelle, commentaire,montant, type, createdAt) VALUES (1, '"+caisse+"', 1, '"+libelle+"', '"+commentaire+"','"+montant+"', '"+type+"', '"+currentDate+"' )");
        int res =  db.insert("INSERT INTO mvment_caisse (id_caisse, id_caisse_mvmt, id_user, libelle, commentaire,montant, type, createdAt) VALUES (1, '"+caisse+"', 1, '"+libelle+"', '"+commentaire+"','"+montant+"', '"+type+"', '"+currentDate+"' )");
        if(res!=0){
            response.sendRedirect("/Caisse-servlet");
        }else{
            getServletContext().getRequestDispatcher("/createMvment.jsp").forward(request, response);
        }
    }


    public void destroy() {
    }
}