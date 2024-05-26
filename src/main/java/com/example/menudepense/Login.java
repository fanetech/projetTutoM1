package com.example.menudepense;
import java.io.*;
import java.rmi.ServerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Database db = new Database();
        ResultSet res =  db.get("SELECT * FROM user WHERE username = '"+username+"' AND password ='"+password+"' ");
        try {
            System.out.println(res);
            if(res.next()) {
                if(Objects.equals(res.getString("username"), username) && Objects.equals(res.getString("password"), password)){
                    getServletContext().getRequestDispatcher("/caisse.jsp").forward(request, response);
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