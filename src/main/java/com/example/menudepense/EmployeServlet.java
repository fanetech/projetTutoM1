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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "employeServlet", value = "/employe-servlet")
public class EmployeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            List<User> userList = new ArrayList<>();
            Database db = new Database();
            ResultSet res =  db.get("SELECT * FROM user");
            while (res.next()) {
                int id = res.getInt("id");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String tel = res.getString("tel");
                String password = res.getString("password");
                String username = res.getString("username");
                String email = res.getString("email");
                String role = res.getString("role");
                Date createdAt = res.getDate("createdAt");
                userList.add(new User( id, nom, prenom,email,password, tel, username, role, createdAt));
            }
            request.setAttribute("users", userList);
            getServletContext().getRequestDispatcher("/employe.jsp").forward(request, response);

        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}