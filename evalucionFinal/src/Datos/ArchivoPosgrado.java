package Datos;

import dominio.Posgrado;
import javafx.geometry.Pos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoPosgrado implements IAccesoPosgrado{
    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoPosgrado() {
        this.archivo = new File("ArchivoPosgrado.dat");
    }

    public ArchivoPosgrado(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    @Override
    public void insertarPublicacion(Posgrado posgrado) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(posgrado.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null) {
                pw.close();
            }
            this.modoEscritura.close();
        }
    }
    private Posgrado crearPosgrado(String linea) {

        String datos[] = linea.split(";");
        Posgrado posgrado = new Posgrado();
        posgrado.setNoDocumento(Integer.parseInt(datos[0]));
        posgrado.setNombre(datos[1]);
        posgrado.setApellido(datos[2]);
        posgrado.setProgramaPosgrado(datos[3]);
        posgrado.setSemestre(Integer.parseInt(datos[4]));
        posgrado.setPromedioSemestre(Double.parseDouble(datos[5]));

        return posgrado;
    }


    @Override
    public List<Posgrado> leerPublicaciones() throws IOException {
        List<Posgrado> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Posgrado posgrado = this.crearPosgrado(linea);
                listado.add(posgrado);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }

    }

    @Override
    public Posgrado buscarPublicacion(int buscar) throws IOException {
        Posgrado encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Posgrado posgrado = this.crearPosgrado(linea);
                if (posgrado.getNoDocumento() ==  buscar) {
                    encontrado = posgrado;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }
    private void renombrarArchivo(File nvoArchivo) throws IOException {
        if (!nvoArchivo.exists())
            nvoArchivo.createNewFile();

        if (!this.archivo.delete()) {
            throw new IOException("No fue posible eliminar el archivo original");
        }

        if (!nvoArchivo.renameTo(this.archivo)) {
            throw new IOException("No fue posible renombrar el archivo temporal");
        }
    }

    @Override
    public void eliminarPublicacion(int buscar) throws IOException {
        try {
            this.modoLectura = new Scanner(this.archivo);
            ArchivoPosgrado archivoTemporal = new ArchivoPosgrado("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Posgrado posgrado = this.crearPosgrado(linea);
                if (posgrado.getNoDocumento() != buscar) {
                    archivoTemporal.insertarPublicacion(posgrado);
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }

    }
}
