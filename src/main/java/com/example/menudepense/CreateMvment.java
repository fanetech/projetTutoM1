package com.example.menudepense;


import com.example.menudepense.models.Caisse;
import com.example.menudepense.models.User;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreateMvmentServlet", value = "/servlet-CreateMvment")
public class CreateMvment extends HttpServlet {
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
        getServletContext().getRequestDispatcher("/createMvment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
            Caisse caisse = (Caisse) session.getAttribute("caisse");
            User user = (User) session.getAttribute("user");
            Caisse caisseMvmt = new Caisse();
            System.out.println("Inside doPost method");
            String libelle = request.getParameter("libelle");
            String commentaire = request.getParameter("commentaire");
            Integer montant = Integer.parseInt(request.getParameter("montant"));
            String type = request.getParameter("type");
            int caisseIdMvmt = Integer.parseInt(request.getParameter("id_caisse_mvmt"));
            LocalDate currentDate = LocalDate.now();
            Database db = new Database();
            int res =  db.insert("INSERT INTO mvment_caisse (id_caisse, id_caisse_mvmt, id_user, libelle, commentaire,montant, type, createdAt) VALUES ('"+caisse.getId()+"', '"+caisseIdMvmt+"', '"+user.getId()+"', '"+libelle+"', '"+commentaire+"','"+montant+"', '"+type+"', '"+currentDate+"' )");

            ResultSet getCaisse =  db.update("SELECT * FROM caisse WHERE id = '"+caisseIdMvmt+"'");
            if(getCaisse!=null){
                if(getCaisse.next()){
                    caisseMvmt.setId(getCaisse.getInt("id"));
                    caisseMvmt.setMoment(getCaisse.getInt("montant"));
                    caisseMvmt.setLibelle(getCaisse.getString("libelle"));
                }
            }
            int caisseMvmtAmountUpdate;
            int caisseAmountUpdate;
            System.out.println("type" + type);
            System.out.println("montant" + montant);
            System.out.println("caisse.getMoment()"+caisse.getMoment());
            System.out.println("caisseMvmt.getMoment()"+caisseMvmt.getMoment());
            if(type.equals("sortie")){
                System.out.println("sortie");
                caisseMvmtAmountUpdate = caisseMvmt.getMoment() + montant;
                caisseAmountUpdate = caisse.getMoment() - montant;
            }else{
                System.out.println("ENTRE");
                System.out.println("caisse.getMoment()"+caisse.getMoment());
                caisseAmountUpdate = caisse.getMoment() + montant;
                caisseMvmtAmountUpdate = caisseMvmt.getMoment() - montant;
            }
            System.out.println("caisseMvmtAmountUpdate"+caisseMvmtAmountUpdate);
            System.out.println("caisseAmountUpdate"+caisseAmountUpdate);
            int updateCaisse =  db.insert("UPDATE caisse SET montant = '"+caisseAmountUpdate+"' WHERE id ='"+caisse.getId()+"'");
            int updateCaisseMvmt =  db.insert("UPDATE caisse SET montant = '"+caisseMvmtAmountUpdate+"' WHERE id ='"+caisseMvmt.getId()+"'");
            caisse.setMoment(caisseAmountUpdate);
            session.setAttribute("caisse", caisse);
            if(res!=0){
                response.sendRedirect("/Caisse-servlet");
            }else{
                getServletContext().getRequestDispatcher("/createMvment.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void destroy() {
    }
}