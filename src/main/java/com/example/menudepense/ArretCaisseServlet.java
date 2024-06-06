package com.example.menudepense;
import com.example.menudepense.models.ArretCaisse;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ArretCaisseServletServlet", value = "/arretCaisse-servlet")
public class ArretCaisseServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try{
            List<ArretCaisse> mvmList = new ArrayList<>();
            Database db = new Database();
            ResultSet resDb =  db.get("SELECT * FROM arret_caisse");
            while (resDb.next()) {
                int id = resDb.getInt("id");
                Integer montant = resDb.getInt("montant");
                String commentaire = resDb.getString("commentaire");
                int decompteArredId = resDb.getInt("decompte_arret_id");
                Date createdAt = resDb.getDate("createdAt");
                int userId = resDb.getInt("id_user");
                mvmList.add(new ArretCaisse( id, montant, commentaire, createdAt, userId, decompteArredId));
            }
            req.setAttribute("arretCaisseList", mvmList);
            getServletContext().getRequestDispatcher("/arretCaisse.jsp").forward(req, res);

        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void  doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {


    }

    public void destroy() {
    }
}