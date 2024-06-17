package com.example.menudepense;

import com.example.menudepense.models.MvmtCaisse;
import com.example.menudepense.models.User;

import java.io.*;
import java.sql.ResultSet;
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

@WebServlet(name = "CreateCaisseServletServlet", value = "/CreateCaisse-servlet")
public class CreateCaisseServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/createCaisse.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String libelle = request.getParameter("libelle");
        Integer montant = Integer.parseInt(request.getParameter("montant"));
        LocalDate currentDate = LocalDate.now();
        Database db = new Database();
        int res =  db.insert("INSERT INTO caisse (libelle, montant, createdAt) VALUES ('"+libelle+"', '"+montant+"', '"+currentDate+"' )");
        if(res!=0){
            response.sendRedirect("/caisseMain-servlet");
        }else{
            response.sendRedirect("/CreateCaisse-servlet");
        }
    }
    public void destroy() {
    }
}