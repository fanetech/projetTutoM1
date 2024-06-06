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
@WebServlet(name = "createArretCaisseServletServlet", value = "/createArretCaisse-servlet")
public class createArretCaisseServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/createArretCaisse.jsp").forward(request, response);

    }

    public void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            String montant = request.getParameter("montant");
            String commentaire = request.getParameter("commentaire");
            int nb_10000 = Integer.parseInt(request.getParameter("nb_10000"));
            int nb_5000 = Integer.parseInt(request.getParameter("nb_5000"));

            int nb_2000 = Integer.parseInt(request.getParameter("nb_2000"));
            int nb_1000 = Integer.parseInt(request.getParameter("nb_1000"));
            int nb_500 = Integer.parseInt(request.getParameter("nb_500"));
            int nb_250 = Integer.parseInt(request.getParameter("nb_250"));
            int nb_200 = Integer.parseInt(request.getParameter("nb_200"));
            int nb_100 = Integer.parseInt(request.getParameter("nb_100"));
            int nb_50 = Integer.parseInt(request.getParameter("nb_50"));
            int nb_25 = Integer.parseInt(request.getParameter("nb_25"));
            int nb_10 = Integer.parseInt(request.getParameter("nb_10"));
            int nb_5 = Integer.parseInt(request.getParameter("nb_5"));
            LocalDate currentDate = LocalDate.now();

            Database db = new Database();
            int res =  db.insertGetid("INSERT INTO decompte_arret ( id_arret, nb_10000, nb_5000, nb_2000,nb_1000, nb_500, nb_250, nb_200, nb_100, nb_50,nb_25,nb_10, nb_5, createdAt) VALUES (1, '"+nb_10000+"', '"+nb_5000+"','"+nb_2000+"', '"+nb_1000+"', '"+nb_500+"', '"+nb_250+"', '"+nb_200+"', '"+nb_100+"', '"+nb_50+"', '"+nb_25+"', '"+nb_10+"', '"+nb_5+"', '"+currentDate+"' )");
            int resAc =  db.insert("INSERT INTO arret_caisse (id_user, commentaire, montant, decompte_arret_id, createdAt) VALUE (1, '"+commentaire+"', '"+montant+"', '"+res+"', '"+currentDate+"')");
            System.out.println(res);
        if(resAc !=0){
            response.sendRedirect("/arretCaisse-servlet");
        }else{
            response.sendRedirect("/createArretCaisse-servlet");
        }
        }catch (Exception e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}