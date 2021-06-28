package vista;



import Negocio.RegistroPosgrado;
import Negocio.RegistroPregrado;
import dominio.Posgrado;
import dominio.Pregrado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class VentanaPrincipal extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tablaPregrado,tablaPostGrado;
    private DefaultTableModel modelo1,modelo2;
    private JButton bBuscar;
    private String pregrado[] = {"NoDocumento", "Nombre", "Apellido", "ProgramaPregrado", "Semestre","Corte 1","Corte2","Corte3"};
    private String postGrado[] = {"NoDocumento", "Nombre", "Apellido", "ProgramaPregrado", "Semestre","Promedio"};
    private RegistroPregrado gestor;
    private RegistroPosgrado gestor2;


    public VentanaPrincipal(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new RegistroPregrado();
        this.gestor2 = new RegistroPosgrado();
        this.setTitle("ventana Principal");
        this.iniciarComponentes();
        this.pack();
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }


    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelResultado();
        this.actualizarTablaPregrado();

    }


    public void iniciarPanelResultado() {
        this.panelResultado = new JScrollPane();
        this.tablaPregrado = new JTable();
        this.modelo1 = new DefaultTableModel(null, this.pregrado);
        this.tablaPregrado.setModel(modelo1);
        this.panelResultado.setViewportView(this.tablaPregrado);
        this.contenedor.add(this.panelResultado, BorderLayout.CENTER);

    }


    public void actualizarTablaPregrado() {
        List<Pregrado> listado = this.gestor.leer();
        this.modelo1.setNumRows(0);
        for (Pregrado pregrado : listado) {
            String linea[] = {""+pregrado.getNoDocumento(),pregrado.getNombre(),pregrado.getApellido(),
                    pregrado.getProgramaPosgrado(),""+pregrado.getSemestre(),""+pregrado.getCorte1(),""+pregrado.getCorte2(),""+pregrado.getCorte3()};
            this.modelo1.addRow(linea);
        }

    }

    public void actualizarTablaPostGrado() {
        List<Posgrado> listado = this.gestor2.leer();
        this.modelo2.setNumRows(0);
        for (Posgrado posgrado : listado) {
            String linea[] = {""+posgrado.getNoDocumento(),posgrado.getNombre(),posgrado.getApellido(),
                    posgrado.getProgramaPosgrado(),""+posgrado.getSemestre(),""+posgrado.getPromedioSemestre()};
            this.modelo2.addRow(linea);
        }

    }



    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }



}
