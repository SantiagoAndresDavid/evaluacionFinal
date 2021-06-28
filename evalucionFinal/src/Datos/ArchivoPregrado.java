package Datos;

import dominio.Posgrado;
import dominio.Pregrado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoPregrado implements IAccesoDatosPregrado {
    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoPregrado() {
        this.archivo = new File("ArchivoPregrado.dat");
    }

    public ArchivoPregrado(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }


    @Override
    public void insertarPublicacion(Pregrado pregrado) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(pregrado.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null) {
                pw.close();
            }
            this.modoEscritura.close();
        }
    }

    private Pregrado crearPregrado(String linea) {

        String datos[] = linea.split(";");
        Pregrado pregrado = new Pregrado();
        pregrado.setNoDocumento(Integer.parseInt(datos[0]));
        pregrado.setNombre(datos[1]);
        pregrado.setApellido(datos[2]);
        pregrado.setProgramaPosgrado(datos[3]);
        pregrado.setSemestre(Integer.parseInt(datos[4]));
        pregrado.setCorte1(Double.parseDouble(datos[5]));
        pregrado.setCorte2(Double.parseDouble(datos[6]));
        pregrado.setCorte3(Double.parseDouble(datos[7]));
        return pregrado;
    }

    @Override
    public List<Pregrado> leerPublicaciones() throws IOException {
        List<Pregrado> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Pregrado pregrado = this.crearPregrado(linea);
                listado.add(pregrado);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null)
                this.modoLectura.close();
        }
    }

    @Override
    public Pregrado buscarPublicacion(int buscar) throws IOException {
        Pregrado encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Pregrado pregrado = this.crearPregrado(linea);
                if (pregrado.getNoDocumento() == buscar) {
                    encontrado = pregrado;
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
            ArchivoPregrado archivoTemporal = new ArchivoPregrado("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Pregrado pregrado = this.crearPregrado(linea);
                if (pregrado.getNoDocumento() != buscar) {
                    archivoTemporal.insertarPublicacion(pregrado);
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
