package com.proyecto;

import java.sql.Connection;
import java.util.List;

public interface IUsuario {

    void insertar(Connection conexion,Usuario usuario);
    void eliminar(Connection conexion,long id);
    List<Usuario> listaUsuarios(Connection conexion);
    Usuario obtenerPorId(Connection conexion, long id);
}