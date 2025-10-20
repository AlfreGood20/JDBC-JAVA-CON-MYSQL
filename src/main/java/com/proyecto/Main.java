package com.proyecto;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexion = Conexion.getInstancia().conexion();
        Conexion.getInstancia().cerrarConexion();
    }
}