import Negocio.RegistroPregrado;
import dominio.Pregrado;
import vista.VentanaPrincipal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Pregrado pregrado = new Pregrado(1234,"a","b","Ciencias",2,2.0,1.0,5.0);
        RegistroPregrado registroPregrado = new RegistroPregrado();
        try {
            registroPregrado.insertar(pregrado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(registroPregrado.leer());
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(null ,true);
    }
}
