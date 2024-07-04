package com.example.menudepense;

import com.example.menudepense.models.ArretCaisse;
import com.example.menudepense.models.DecompoMoney;
import com.example.menudepense.models.MvmtCaisse;
import com.example.menudepense.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "LogoutServlet", value = "/Logout-servlet")
public class Logout extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Worlds!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("/login");
    }

    public void destroy() {
    }
}