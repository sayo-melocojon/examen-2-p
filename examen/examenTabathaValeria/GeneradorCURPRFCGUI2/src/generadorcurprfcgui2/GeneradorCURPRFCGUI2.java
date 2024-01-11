/**
 * 
 *@author Rivero Rodriguez Tabatha Valeria
 * 10/01/24
 * sayo melocojon.
 */
package generadorcurprfcgui2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class GeneradorCURPRFCGUI2 extends JFrame {

    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtFechaNacimiento;
    private JComboBox<String> comboEstado;
    private JButton btnGenerar;
    private JTextArea txtResultado;

    public GeneradorCURPRFCGUI2() {
        setTitle("Generador de CURP y RFC");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido Paterno:"));
        txtApellidoPaterno = new JTextField();
        add(txtApellidoPaterno);

        add(new JLabel("Apellido Materno:"));
        txtApellidoMaterno = new JTextField();
        add(txtApellidoMaterno);

        add(new JLabel("Fecha de Nacimiento (dd/MM/yyyy):"));
        txtFechaNacimiento = new JTextField();
        add(txtFechaNacimiento);

        add(new JLabel("Estado de Nacimiento:"));
        String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas",
                            "Chihuahua", "Coahuila", "Colima", "Ciudad de México", "Durango", "Guanajuato",
                            "Guerrero", "Hidalgo", "Jalisco", "Estado De México", "Michoacán", "Morelos", "Nayarit",
                            "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí",
                            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        comboEstado = new JComboBox<>(estados);
        add(comboEstado);

        btnGenerar = new JButton("Generar CURP y RFC");
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarYMostrarCURPyRFC2();
            }
        });
        add(btnGenerar);

        add(new JLabel("Resultado:"));
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        add(new JScrollPane(txtResultado));
    }

    private void generarYMostrarCURPyRFC2() {
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();
        String estadoNacimiento = (String) comboEstado.getSelectedItem();

        String curp = generarCURP(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, estadoNacimiento);
        String rfc = generarRFC(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, estadoNacimiento);

        txtResultado.setText("CURP: " + curp + "\nRFC: " + rfc);
    }

    private String generarCURP(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String estadoNacimiento) {
        // Lógica para generar CURP (simplificada)
        // Se deberían seguir las reglas oficiales para un uso real
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String fechaNacimientoCURP = sdf.format(new Date(fechaNacimiento));

        return apellidoPaterno.substring(0, 2).toUpperCase() +
                apellidoMaterno.charAt(0) +
                nombre.charAt(0) +
                fechaNacimientoCURP +
                estadoNacimiento.substring(0, 1).toUpperCase() +
                "X"; // Sexo desconocido (ya que no se proporciona en este ejemplo)
    }

    private String generarRFC(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String estadoNacimiento) {
        // Lógica para generar RFC (simplificada)
        // Se deberían seguir las reglas oficiales para un uso real
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String fechaNacimientoRFC = sdf.format(new Date(fechaNacimiento));

        Random random = new Random();
        int homoclave = random.nextInt(100);

        return apellidoPaterno.substring(0, 2).toUpperCase() +
                apellidoMaterno.charAt(0) +
                nombre.charAt(0) +
                fechaNacimientoRFC +
                estadoNacimiento.substring(0, 1).toUpperCase() +
                homoclave;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GeneradorCURPRFCGUI2().setVisible(true);
            }
        });
    }
}
  
}
