package com.example.menudepense;

import com.example.menudepense.models.MvmtCaisse;
import com.example.menudepense.models.User;

import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CaisseServlet", value = "/Caisse-servlet")
public class Caisse extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect("/login");
                return;
            }
            User user = (User) session.getAttribute("user");
            System.out.println("user: " + user);
            System.out.println("user: " + user.getId());
            List<MvmtCaisse> mvmList = new ArrayList<>();
            Database db = new Database();
            ResultSet res =  db.get("SELECT * FROM mvment_caisse");
            while (res.next()) {
                int id = res.getInt("id");
                Integer montant = res.getInt("montant");
                String commentaire = res.getString("commentaire");
                String libelle = res.getString("libelle");
                String beneficiaire = res.getString("beneficiaire");
                String type = res.getString("type");
                String receveur = res.getString("receveur");
                Date createdAt = res.getDate("createdAt");
                mvmList.add(new MvmtCaisse( id, montant, commentaire, libelle, beneficiaire, type, receveur, createdAt));
            }
            request.setAttribute("mvmtCaisseList", mvmList);
            getServletContext().getRequestDispatcher("/caisse.jsp").forward(request, response);

        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}