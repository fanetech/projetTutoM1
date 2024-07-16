package com.example.menudepense.database;

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
            System.out.println("connection error. =>"+e);
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet  get(String query){
        try{
            Connection connexion = connexionDB();
            Statement statement = connexion.createStatement();
            //            while (resultSet.next()){
//                System.out.println(resultSet.getString("nom"));
//                System.out.println(resultSet.getString("prenom"));
//            }
            return statement.executeQuery(query);

        }catch (SQLException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }
        return null;
    }

    public int insert(String query){
        try{
            Connection connexion = connexionDB();
            Statement statement = connexion.createStatement();
            return statement.executeUpdate(query);

        }catch (SQLException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }
        return 0;
    }

    public int insertGetid(String query){
        try{
            Connection connexion = connexionDB();
            Statement statement = connexion.createStatement();
            int affectedRows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            // Retrieve the generated keys
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1); // Assumes the key is a long. Adjust as needed.
                return id;
            }

        }catch (SQLException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet update(String query){
        try{
            Connection connexion = connexionDB();
            Statement statement = connexion.createStatement();
            return statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }
        return null;
    }

    public int delete(String query){
        try{
            Connection connexion = connexionDB();
            Statement statement = connexion.createStatement();
            return statement.executeUpdate(query);

        }catch (SQLException e){
            System.out.println("connection error =>"+e);
            e.printStackTrace();
        }
        return 0;
    }

}
