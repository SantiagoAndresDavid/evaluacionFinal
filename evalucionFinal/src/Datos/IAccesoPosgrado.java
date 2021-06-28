package Datos;

import dominio.Posgrado;
import dominio.Pregrado;

import java.io.IOException;
import java.util.List;

public interface IAccesoPosgrado {
    void insertarPublicacion(Posgrado posgrado) throws IOException;
    List<Posgrado> leerPublicaciones()throws IOException;
    Posgrado buscarPublicacion(int buscar)throws IOException;
    void eliminarPublicacion(int buscar)throws IOException;
}
