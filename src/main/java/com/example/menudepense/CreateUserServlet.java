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

@WebServlet(name = "CreateUserServletServlet", value = "/CreateUser-servlet")
public class CreateUserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/createUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest res, HttpServletResponse req) throws ServletException, IOException {
        System.out.println("Inside doPost method");
        String nom = res.getParameter("nom");
        String prenom = res.getParameter("prenom");
        String tel = res.getParameter("tel");
        String password = res.getParameter("password");
        String username = res.getParameter("username");
        String email = res.getParameter("email");
        LocalDate currentDate = LocalDate.now();
        Database db = new Database();
        int reqCreated =  db.insert("INSERT INTO user ( nom, prenom, tel, password,username, email, createdAt) VALUES ('"+nom+"', '"+prenom+"', '"+tel+"','"+password+"', '"+username+"', '"+email+"', '"+currentDate+"' )");
        if(reqCreated!=0){
            req.sendRedirect("/employe-servlet");
        }else{
            getServletContext().getRequestDispatcher("/createUser.jsp").forward(res, req);
        }
    }
    public void destroy() {
    }
}