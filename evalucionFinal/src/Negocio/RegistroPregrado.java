package Negocio;

import Datos.ArchivoPregrado;
import Datos.IAccesoDatosPregrado;
import dominio.Pregrado;

import java.io.IOException;
import java.util.List;

public class RegistroPregrado {
    private IAccesoDatosPregrado datos;


    public RegistroPregrado() {
        this.datos = new ArchivoPregrado();
    }

    public void insertar(Pregrado pregrado) throws IOException {
        datos.insertarPublicacion(pregrado);
    }

    public List<Pregrado> leer() {
        try {
            return datos.leerPublicaciones();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pregrado buscarPor(int buscar) {
        try {
            return datos.buscarPublicacion(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void eliminar(int buscar) {
        try {
            datos.eliminarPublicacion(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Double calcularPromedio(int buscar){
        try {
            Pregrado pregrado = datos.buscarPublicacion(buscar);
            double promedio = pregrado.getCorte1() + pregrado.getCorte2() + pregrado.getCorte3() / 3 ;
            return promedio;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
