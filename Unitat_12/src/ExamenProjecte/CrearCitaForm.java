package ExamenProjecte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrearCitaForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btnAfegir;
    private JTable taula;
    private ControladorBD controladorBD;

    private JComboBox<String> comboBoxContactes;
    private ArrayList<String> nomsContactes;

    public CrearCitaForm(ControladorBD controladorBD, JTable taula, ArrayList<String> nomsContactes) {
        this.controladorBD = controladorBD;
        this.taula = taula;
        this.nomsContactes = nomsContactes;

        formulari();
        configurarFinestra();
    }

    private void formulari() {
        setTitle("Crear Cita");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulari = new JPanel(new GridLayout(4, 2));
        panelFormulari.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblData = new JLabel("Data:");
        JFormattedTextField txtData = new JFormattedTextField(createFormatter("##-##-####"));

        JLabel lblHora = new JLabel("Hora:");
        JFormattedTextField txtHora = new JFormattedTextField(createFormatter("##:##"));

        JLabel lblDescripcio = new JLabel("Descripció:");
        JTextField txtDescripcio = new JTextField(20);

        JLabel lblContacte = new JLabel("Contacte:");
        comboBoxContactes = new JComboBox<>(nomsContactes.toArray(new String[nomsContactes.size()]));

        panelFormulari.add(lblData);
        panelFormulari.add(txtData);
        panelFormulari.add(lblHora);
        panelFormulari.add(txtHora);
        panelFormulari.add(lblDescripcio);
        panelFormulari.add(txtDescripcio);
        panelFormulari.add(lblContacte);
        panelFormulari.add(comboBoxContactes);

        add(panelFormulari, BorderLayout.CENTER);

        btnAfegir = new JButton("Afegir");
        btnAfegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = txtData.getText().trim();
                String hora = txtHora.getText().trim();
                String descripcio = txtDescripcio.getText().trim();
                String nomContacte = (String) comboBoxContactes.getSelectedItem();

                boolean dadesCorrectes = comprovarDades(data, hora, descripcio);

                if (dadesCorrectes) {
                    // Convertir la data al format desitjat per la base de dades
                    String dataSQL = convertirData(data);
                    int idContacte = controladorBD.obtenirIdContacte(nomContacte);
                    controladorBD.crearCita(dataSQL, hora, descripcio, idContacte);
                    controladorBD.actualitzarTaulaCites(taula);

                    dispose(); // Tancar el formulari després d'afegir la cita.
                } else {
                	Missatge.error(null, "Per favor, omple tots els camps correctament.");
                }
            }
        });

        add(btnAfegir, BorderLayout.SOUTH);
    }

    private boolean comprovarDades(String data, String hora, String descripcio) {
        // Verificar que no s'hagi deixat cap camp buit.
        return !data.isEmpty() && !hora.isEmpty() && !descripcio.isEmpty();
    }

    private String convertirData(String data) {
        try {
            DateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
            DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = originalFormat.parse(data);
            return targetFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private MaskFormatter createFormatter(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
        } catch (java.text.ParseException e) {
            System.err.println("Format de màscara invàlid: " + e.getMessage());
        }
        return formatter;
    }

    private void configurarFinestra() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
