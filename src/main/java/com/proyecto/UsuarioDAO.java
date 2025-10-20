package com.proyecto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuario{

    @Override
    public void insertar(Connection conexion, Usuario usuario) {
        String query = """
                        INSERT INTO usuarios (nombre,apellido,telefono,correo)
                        VALUES (?, ?, ?,?);
                """;
        try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setString(3, usuario.getTelefono());
            sentencia.setString(4, usuario.getCorreo());

            int cambio =sentencia.executeUpdate();
             System.out.println("Filas afectadas: " + cambio);

            if(cambio > 0){
                System.out.println("INSERTADO CORRECTAMENTE");
                System.out.println(usuario.toString());
            }
        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void eliminar(Connection conexion, long id) {
        if (id <=0) {
            System.out.println("el id no puede ser menor y/o igual a 0");
            return;
        }

        String query = "DELETE FROM usuarios WHERE id = ?";
        try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setLong(1, id);

            int cambio = sentencia.executeUpdate();

            if(cambio > 0){
                System.out.println("Se elimino correctamente");
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }

    }


    @Override
    public List<Usuario> listaUsuarios(Connection conexion) {
        List<Usuario> usuarios=new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try(java.sql.Statement sentencia = conexion.createStatement()){
            try(ResultSet resultado= sentencia.executeQuery(query)){
                while (resultado.next()) {
                    Usuario usuario= new Usuario();
                    
                    usuario.setId(String.valueOf(resultado.getLong("id")));
                    usuario.setNombre(resultado.getString("nombre"));
                    usuario.setApellido(resultado.getString("apellido"));
                    usuario.setTelefono(resultado.getString("telefono"));
                    usuario.setCorreo(resultado.getString("correo"));
                    usuarios.add(usuario);
                }

                return usuarios;
            }
        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }

        return usuarios;
    }

    @Override
    public Usuario obtenerPorId(Connection conexion, long id) {
        String query = "SELECT * FROM usuarios WHERE id = ?;";

        try (PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setLong(1, id);
            try(ResultSet resultado = sentencia.executeQuery()){
                if(resultado.next()){
                    Usuario usuario= new Usuario(resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("telefono"), resultado.getString("correo"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }

        return null;
    }
}