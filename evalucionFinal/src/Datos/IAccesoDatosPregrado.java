package Datos;

import dominio.Pregrado;

import java.io.IOException;
import java.util.List;

public interface IAccesoDatosPregrado {
    void insertarPublicacion(Pregrado pregrado) throws IOException;
    List<Pregrado> leerPublicaciones()throws IOException;
    Pregrado buscarPublicacion(int buscar)throws IOException;
    void eliminarPublicacion(int buscar)throws IOException;
}
