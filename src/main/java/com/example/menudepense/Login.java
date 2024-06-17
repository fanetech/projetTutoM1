package com.example.menudepense;
import com.example.menudepense.models.User;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Database db = new Database();
        ResultSet res =  db.get("SELECT * FROM user WHERE username = '"+username+"' AND password ='"+password+"' ");
        try {
            System.out.println(res);
            if(res.next()) {
                if(Objects.equals(res.getString("username"), username) && Objects.equals(res.getString("password"), password)){
                    User user = new User();
                    user.setEmail(res.getString("email"));
                    user.setNom(res.getString("nom"));
                    user.setPrenom(res.getString("prenom"));
                    user.setTel(res.getString("tel"));
                    user.setRole(res.getString("role"));
                    user.setCreatedAt(res.getDate("createdAt"));
                    user.setId(res.getInt("id"));
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
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