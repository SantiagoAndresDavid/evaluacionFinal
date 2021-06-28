package Negocio;

import Datos.ArchivoPosgrado;
import Datos.ArchivoPregrado;
import Datos.IAccesoDatosPregrado;
import Datos.IAccesoPosgrado;
import dominio.Posgrado;
import dominio.Pregrado;

import java.io.IOException;
import java.util.List;

public class RegistroPosgrado {
    private IAccesoPosgrado datos;

    public RegistroPosgrado() {
        this.datos = new ArchivoPosgrado();
    }

    public void insertar(Posgrado posgrado) throws IOException {

        datos.insertarPublicacion(posgrado);
    }

    public List<Posgrado> leer() {
        try {
            return datos.leerPublicaciones();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Posgrado buscarPor(int buscar) {
        try {
            return datos.buscarPublicacion(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void eliminar(int buscar){
        try {
            datos.eliminarPublicacion(buscar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
