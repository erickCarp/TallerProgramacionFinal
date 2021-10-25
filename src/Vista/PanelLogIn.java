/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Auxiliar.TextFieldPlaceHolder;
import Modelo.Auxiliar.StyledButtonUI;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Objetos.Usuario;
import java.awt.Font;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author hp
 */
public class PanelLogIn extends JPanel {

    public static PanelLogIn PNLLOGIN;
    private MenuPrincipal mnuPrincipal;
    private JLabel lbUsuario;
    private JLabel lbCuenta;
    private TextFieldPlaceHolder txtUsuario;
    private TextFieldPlaceHolder txtPassword;
    private JButton btnInicio;
    private JButton btnRegistro;
    Usuario usuario;

    ///Singleton
    public static JPanel getInstance(MenuPrincipal mnuPrincipal) {
        PNLLOGIN = new PanelLogIn();
        PNLLOGIN.setVentanaInicio(mnuPrincipal);
        return PNLLOGIN;
    }

    public PanelLogIn() {
        Color fondo = new Color(232, 255, 255);
        this.setBackground(fondo);
        this.setBounds(0, 0, 900, 850);
        this.setVisible(true);
        this.setLayout(null);

        lbUsuario = new JLabel("LOGIN");
        lbUsuario.setBounds(300, 60, 300, 50);
        this.add(lbUsuario);

        txtUsuario = new TextFieldPlaceHolder();
        txtUsuario.setBounds(300, 120, 300, 50);
        txtUsuario.setPlaceholder("Usuario");
        this.add(txtUsuario);

        txtPassword = new TextFieldPlaceHolder();
        txtPassword.setBounds(300, 200, 300, 50);
        txtPassword.setPlaceholder("Contraseña");
        this.add(txtPassword);

        btnInicio = new JButton("LOG IN");
        btnInicio.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnInicio.setBackground(new Color(54, 60, 70));
        btnInicio.setBounds(360, 280, 200, 40);
        btnInicio.setForeground(Color.white);
        btnInicio.setUI(new StyledButtonUI());

        lbCuenta = new JLabel("No tienes cuenta? pincha debajo");
        lbCuenta.setBounds(360, 330, 200, 40);
        this.add(lbCuenta);

        btnRegistro = new JButton("SIGN UP");
        btnRegistro.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnRegistro.setBackground(new Color(54, 60, 70));
        btnRegistro.setBounds(360, 380, 200, 40);
        btnRegistro.setForeground(Color.white);
        btnRegistro.setUI(new StyledButtonUI());

        this.add(btnInicio);
        this.add(btnRegistro);

        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String usr = txtUsuario.getText();
                String pass = txtPassword.getText();

                setDato(usr);
                boolean next = login(pass);
                if (next) {

                    // agrego mi usuario logueado
                    Usuario usuario = getDato();
                    Usuario.Usuariolog = usuario;
                    mnuPrincipal.cargaPanel(PanelAvatar.getInstance(mnuPrincipal));
                } else {
                    showMessageDialog(null, "Usuario o contrasena erronea");
                }
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                mnuPrincipal.cargaPanel(PanelSignUp.getInstance(mnuPrincipal));
            }
        });
        this.repaint();
    }

    public void setDato(String dato) {
        Usuario usr = Usuario.Usuarios.get(dato);
        usuario = usr;
    }

    public Usuario getDato() {
        return usuario;
    }

    public void setVentanaInicio(MenuPrincipal ventanaInicio) {
        this.mnuPrincipal = ventanaInicio;
    }

    private boolean login(String pass) {

        Usuario usuario = getDato();
        if (usuario == null) {
            return false;
        }
        if (!usuario.getPass().equals(pass)) {
            return false;
        }
        return true;
    }

}
