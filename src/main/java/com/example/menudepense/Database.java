package com.example.menudepense;

import java.sql.*;

public class Database {

    public Database() {
    }

    public void  connexionDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/menudepense",
                    "root",
                    "root"
            );
//            System.out.println("resultSet.getString(\"nom\")");
//            Statement statement = connexion.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("nom"));
//                System.out.println(resultSet.getString("prenom"));
//            }

        }catch (SQLException | ClassNotFoundException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }

    }
}
