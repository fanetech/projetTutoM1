package com.example.menudepense;

import java.sql.*;

public class Database {

    public Database() {
    }

    public Connection  connexionDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connexion = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/menudepense",
                    "root",
                    "root"
            );
            return connexion;
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet  get(String query){
        try{
            Connection connexion = connexionDB();
            System.out.println("resultSet.getString(\"nom\")");
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.println(resultSet.getString("nom"));
                System.out.println(resultSet.getString("prenom"));
            }
            return resultSet;

        }catch (SQLException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }
        return null;
    }

}
