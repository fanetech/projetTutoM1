package com.example.menudepense;

import java.sql.*;

public class Database {

    public Database() {
    }

    public void  connexionDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/menuDepense",
                    "root",
                    "root"
            );
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");

            while (resultSet.next()){
                System.out.println(resultSet.getString("nom"));
                System.out.println(resultSet.getString("prenom"));
            }

        }catch (SQLException | ClassNotFoundException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }

    }
}
