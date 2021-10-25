/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Auxiliar.StyledButtonUI;
import Modelo.Auxiliar.TextFieldPlaceHolder;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;
import Modelo.Objetos.Usuario;
import java.awt.Font;

/**
 *
 * @author hp
 */
public class PanelSignUp extends JPanel {

    public static PanelSignUp PNLSINGUP;
    private MenuPrincipal mnuPrincipal;
    private JLabel lbTitulo;
    private JLabel lbNombre;
    private JLabel lbUsuario;
    private JLabel lbPassword;
    private TextFieldPlaceHolder txtNombre;
    private TextFieldPlaceHolder txtUsuario;
    private TextFieldPlaceHolder txtPassword;
    private JButton btnRegistrar;

    ///singleton
    public static JPanel getInstance(MenuPrincipal ventana) {
        PNLSINGUP = new PanelSignUp(ventana);
        return PNLSINGUP;
    }

    public PanelSignUp(MenuPrincipal mnuPrincipal) {
        this.mnuPrincipal = mnuPrincipal;
        Color fondo = new Color(232, 255, 255);
        this.setBackground(fondo);
        this.setBounds(0, 0, 900, 850);
        this.setVisible(true);
        this.setLayout(null);

        lbTitulo = new JLabel();
        lbTitulo.setText("CREA UNA CUENTA");
        lbTitulo.setSize(30, 30);
        lbTitulo.setBounds(380, 0, 300, 100);
        this.add(lbTitulo);

        /*
        txtNombre = new TextFieldPlaceHolder();
        txtNombre.setBounds(300, 90, 300, 50);
        txtNombre.setPlaceholder("Usuario");
        this.add(txtNombre);

        txtPassword = new TextFieldPlaceHolder();
        txtPassword.setBounds(300, 200, 300, 50);
        txtPassword.setPlaceholder("Contraseña");
        this.add(txtPassword);
         */
        // text nombre
        txtNombre = new TextFieldPlaceHolder();
        txtNombre.setBounds(300, 90, 300, 50);
        txtNombre.setPlaceholder("Nombre");
        this.add(txtNombre);

        // text usuario
        txtUsuario = new TextFieldPlaceHolder();
        txtUsuario.setBounds(300, 160, 300, 50);
        txtUsuario.setPlaceholder("Usuario");
        this.add(txtUsuario);
        // text pass
        txtPassword = new TextFieldPlaceHolder();
        txtPassword.setBounds(300, 230, 300, 50);
        txtPassword.setPlaceholder("Password");
        this.add(txtPassword);

        // button iniciar
        btnRegistrar = new JButton("CREAR USUARIO");
        btnRegistrar.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnRegistrar.setBackground(new Color(54, 60, 70));
        btnRegistrar.setBounds(360, 300, 200, 40);
        btnRegistrar.setForeground(Color.white);
        btnRegistrar.setUI(new StyledButtonUI());

        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String usr = txtUsuario.getText();
                String pass = txtPassword.getText();

                boolean entro = validarCampos(nombre, usr, pass);
                if (entro) {
                    mnuPrincipal.cargaPanel(PanelLogIn.getInstance(mnuPrincipal));
                } else {
                    showMessageDialog(null, "Falta datos por rellenar");
                }
            }
        });
        this.add(btnRegistrar);
        this.repaint();
    }

    /// validar
    public boolean validarCampos(String nombre, String usuario, String password) {

        if (nombre.length() <= 0) {
            return false;
        }
        if (usuario.length() <= 0) {
            return false;
        }
        if (password.length() <= 0) {
            return false;
        }

        new Usuario(nombre, usuario, password);

        return true;

    }

}
