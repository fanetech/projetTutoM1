package com.example.menudepense;
import com.example.menudepense.database.Database;
import com.example.menudepense.models.Caisse;
import com.example.menudepense.models.User;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", value = "/login")
public class Login extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Database db = new Database();
        ResultSet res =  db.get("SELECT * FROM user WHERE username = '"+username+"' AND password ='"+password+"' ");
        List<Caisse> caisseList = new ArrayList<>();


            if(res.next()) {
                if(Objects.equals(res.getString("username"), username) && Objects.equals(res.getString("password"), password)){
                    User user = new User();
                    user.setEmail(res.getString("email"));
                    user.setNom(res.getString("nom"));
                    user.setPrenom(res.getString("prenom"));
                    user.setTel(res.getString("tel"));
                    user.setRole(res.getString("role"));
                    user.setCaisseId(res.getInt("caisseId"));
                    user.setCreatedAt(res.getDate("createdAt"));
                    user.setId(res.getInt("id"));

                    session.setAttribute("user", user);
                    System.out.println("role: " + user.getRole());
                    System.out.println("res.getString(\"role\") " + res.getString("role"));
                    ResultSet ress =  db.get("SELECT * FROM caisse");
                    while (ress.next()) {
                        int id = ress.getInt("id");
                        Integer montant = ress.getInt("montant");
                        String libelle = ress.getString("libelle");
                        Date createdAt = ress.getDate("createdAt");
                        caisseList.add(new Caisse( id, montant, libelle, createdAt));
                    }
                    session.setAttribute("caisses", caisseList);
                    Caisse foundCaisse = caisseList.stream()
                            .filter(caisse -> caisse.getId() == user.getCaisseId()) // Replace with your condition
                            .findFirst()
                            .orElse(null);

                    System.out.println(foundCaisse);

                    if (foundCaisse != null) {
                        session.setAttribute("caisse", foundCaisse);
                    }
                    response.sendRedirect("/");

                }else{
                    System.out.println("no connect");
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }else{
                System.out.println("no connect");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}