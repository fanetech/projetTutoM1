package com.example.menudepense;
import java.io.*;
import java.rmi.ServerException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", value = "/login")
public class Login extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        Database db = new Database();
        ResultSet res =  db.get("SELECT * FROM user WHERE username='fanetech'");
        try {
            if(res.next()) {
                while (res.next()){
                    System.out.println(res.getString("nom"));
                    System.out.println(res.getString("prenom"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public void destroy() {
    }
}