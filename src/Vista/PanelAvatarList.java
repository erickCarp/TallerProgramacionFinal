/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import Modelo.AvatarLista;

/**
 *
 * @author hp
 */
public class PanelAvatarList extends JPanel {

    public static PanelAvatarList PNLAVATARLIST;
    private MenuPrincipal mnuPrincipal;
    private JList jlLista;

    public static JPanel getInstance(MenuPrincipal ventana) {

        if (PNLAVATARLIST == null) {
            PNLAVATARLIST = new PanelAvatarList();
        }

        PNLAVATARLIST.setMenuPrincipal(ventana);
        PNLAVATARLIST.repaint();
        return PNLAVATARLIST;
    }

    public PanelAvatarList() {
        Color fondo = new Color(232, 255, 255);
        this.setBackground(fondo);
        this.setBounds(0, 0, 900, 850);
        this.setVisible(true);
        this.setLayout(null);

        jlLista = new JList();
        jlLista.setBounds(100, 100, 300, 400);
        jlLista.setModel(lista());
        this.add(jlLista);
    }

    private DefaultListModel lista() {
        DefaultListModel lmModel = new DefaultListModel();

        List<String> keys = new ArrayList<>(AvatarLista.avatares.keySet());
        for (String llave : keys) {

            lmModel.addElement(AvatarLista.avatares.get(llave));
        }
        return lmModel;
    }

    public void setMenuPrincipal(MenuPrincipal mnuPrincipal) {
        this.mnuPrincipal = mnuPrincipal;
    }

}
