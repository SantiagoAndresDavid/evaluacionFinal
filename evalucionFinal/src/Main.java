import Negocio.RegistroPosgrado;
import Negocio.RegistroPregrado;
import dominio.Posgrado;
import dominio.Pregrado;
import vista.VentanaPrincipal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Posgrado posgrado = new Posgrado(1234,"a","b","ciencias",1,4.0);
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(null ,true);

    }
}
