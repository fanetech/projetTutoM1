package com.example.menudepense;

import com.example.menudepense.models.User;

import java.io.*;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) session.getAttribute("user");
        System.out.println("user: " + user);
        System.out.println("user: " + user.getId());
      getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    public void destroy() {
    }
}