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
import java.awt.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet(name = "EditArretCaisseServletServlet", value = "/EditArretCaisse-servlet/*")
public class EditArretCaisseServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
        String pathInfo = request.getPathInfo(); // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
            return;
        }

        String[] pathParts = pathInfo.split("/");
        System.out.println(pathParts);
        if (pathParts.length < 1) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            return;
        }

        int id;

            id = Integer.parseInt(pathParts[1]);
            Database db = new Database();
            ResultSet res =  db.update("SELECT * FROM arret_caisse WHERE id = '"+id+"'");
            if(res!=null){
                if(res.next()){
                    ArretCaisse mvm = new ArretCaisse();
                    mvm.setId(res.getInt("id"));
                    mvm.setMoment(res.getInt("montant"));
                    mvm.setCommentaire(res.getString("commentaire"));
                    mvm.setDecompteArretId(res.getInt("decompte_arret_id"));
                    mvm.setUserId(res.getInt("id_user"));
                    mvm.setCreatedAt(res.getDate("createdAt"));
                    request.setAttribute("mvm", mvm);
                    getServletContext().getRequestDispatcher("/editArretCaisse.jsp").forward(request, response);
//                    System.out.println("eee"+mvm.getDecompteArretId());
//                    ResultSet decomRes =  db.update("SELECT * FROM decompte_arret WHERE id = '"+mvm.getDecompteArretId()+"'");
//                    if(decomRes!=null){
//                        if(decomRes.next()){
//                            System.out.println("eee"+mvm.getDecompteArretId());
//                            DecompoMoney decom = new DecompoMoney();
//                            System.out.println("sss"+decom);
//                            decom.setId(decomRes.getInt("id"));
//                            decom.setNb_10000(decomRes.getInt("nb_10000"));
//                            decom.setNb_5000(decomRes.getInt("nb_5000"));
//                            decom.setNb_2000(decomRes.getInt("nb_2000"));
//                            decom.setNb_1000(decomRes.getInt("nb_1000"));
//                            decom.setNb_500(decomRes.getInt("nb_500"));
//                            decom.setNb_250(decomRes.getInt("nb_250"));
//                            decom.setNb_200(decomRes.getInt("nb_200"));
//                            decom.setNb_100(decomRes.getInt("nb_100"));
//                            decom.setNb_50(decomRes.getInt("nb_50"));
//                            decom.setNb_25(decomRes.getInt("nb_25"));
//                            decom.setNb_10(decomRes.getInt("nb_10"));
//                            decom.setNb_5(decomRes.getInt("nb_5"));
//                            request.setAttribute("decom", decomRes);
//
//                        }
//                    }

                }

            }else{
                getServletContext().getRequestDispatcher("/editArretCaisse.jsp/"+id).forward(request, response);
            }
        } catch (NumberFormatException | SQLException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
            return;
        }
    }

    public void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = request.getPathInfo(); // /{id}
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
            return;
        }

        String[] pathParts = pathInfo.split("/");
        if (pathParts.length < 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            return;
        }

        int id;
        id = Integer.parseInt(pathParts[1]);
        String montant = request.getParameter("montant");
        String commentaire = request.getParameter("commentaire");
        Database db = new Database();
        int res =  db.insert("UPDATE arret_caisse SET montant = '"+montant+"', commentaire = '"+commentaire+"'");
        if(res!=0){
            response.sendRedirect("/arretCaisse-servlet");
        }else{
            response.sendRedirect("/EditArretCaisse-servlet/"+id);
        }
    }


    public void destroy() {
    }
}