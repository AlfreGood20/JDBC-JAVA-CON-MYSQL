package com.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private Connection conexion=null;
    private final String url = "jdbc:mysql://localhost:3306/db_unidad_4";
    private final String username = "root";
    private final String password = "admin";

    private Conexion(){
        try{
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("CONEXION EXITOSA \n");
        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }

        return instancia;
    }

    public Connection conexion(){
        try{
            if(conexion == null || conexion.isClosed()){
                conexion = DriverManager.getConnection(url, username, password);
            }
        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }

        return conexion;
    }

    public void cerrarConexion(){
        try{
            if(conexion != null || !conexion.isClosed()){
                conexion.close();
                System.out.println("\nCONEXIÓN CERRADA");
            }
        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

}