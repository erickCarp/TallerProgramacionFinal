/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author hp
 */
public class MenuPrincipal extends JFrame {

    private JPanel pnlSelect;
    private MenuPrincipal ventana;
    private JMenu menu;
    private JMenuItem jItusuarios, jItlistas, jItavatares;

    public MenuPrincipal() {
        this.ventana = this;
        ///cargar barra de opciones        
        menuOpciones();

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 850);
        this.setLayout(null);

        cargaPanel(PanelLogIn.getInstance(this));
    }

    public void cargaPanel(JPanel pnl) { //mostramos el panel que se escogio en el bar
        if (pnlSelect != null) { // si hay quitamos
            this.remove(pnlSelect);
        }
        pnlSelect = pnl;
        this.add(pnl);
        this.repaint();

    }

    public void menuOpciones() {
        JMenuBar barraMenu = new JMenuBar();
        menu = new JMenu("Opciones");
        jItusuarios = new JMenuItem("Usuarios");
        jItlistas = new JMenuItem("listas");
        jItavatares = new JMenuItem("Avatares");
        menu.add(jItusuarios);
        menu.add(jItlistas);
        menu.add(jItavatares);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        jItusuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargaPanel(new PanelSignUp(ventana));
            }
        });
        jItavatares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargaPanel(new PanelAvatar(ventana));
            }
        });
        jItlistas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargaPanel(new PanelAvatarList());
            }
        });
    }

}
