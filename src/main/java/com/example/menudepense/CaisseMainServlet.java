package com.example.menudepense;


import com.example.menudepense.models.Caisse;
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

@WebServlet(name = "CaisseMainServletServlet", value = "/caisseMain-servlet")
public class CaisseMainServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("user") == null) {
                response.sendRedirect("/login");
                return;
            }
            User user = (User) session.getAttribute("user");
            List<Caisse> mvmList = new ArrayList<>();
            Database db = new Database();
            ResultSet res =  db.get("SELECT * FROM caisse");
            while (res.next()) {
                int id = res.getInt("id");
                Integer montant = res.getInt("montant");
                String libelle = res.getString("libelle");
                Date createdAt = res.getDate("createdAt");
                mvmList.add(new Caisse( id, montant, libelle, createdAt));
            }
            request.setAttribute("caisse", mvmList);
            getServletContext().getRequestDispatcher("/caisseMain.jsp").forward(request, response);

        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}