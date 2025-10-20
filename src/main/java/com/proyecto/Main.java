package com.proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conexion = Conexion.getInstancia().conexion();
        UsuarioDAO dao = new UsuarioDAO();

        /*String crearTabla = """
                            CREATE TABLE usuarios (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                nombre VARCHAR (255),
                                apellido VARCHAR (255),
                                telefono VARCHAR (10),
                                correo VARCHAR (255)
                            );
                            """;S
        try(Statement sentencia = conexion.createStatement()){
            sentencia.execute(crearTabla);
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }*/
        
        //dao.insertar(conexion, new Usuario("HOLA", "MUNDO", "99-66", "@gmail.com"));

        /*System.out.println("");
        List<Usuario> usuarios = dao.listaUsuarios(conexion);
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }*/

        /*Usuario usuario = dao.obtenerPorId(conexion, 3);
        System.out.println(usuario == null ? "USUARIO NO ENCONTRADO":usuario.toString());

        /*dao.eliminar(conexion, 1);*/
        
        Conexion.getInstancia().cerrarConexion();
    }
}