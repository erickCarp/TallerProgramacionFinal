/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Auxiliar.StyledButtonUI;
import Modelo.Auxiliar.TextFieldPlaceHolder;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Modelo.TipoParte;
import Modelo.ParteDelCuerpo;
import Modelo.ParteDelCuerpo;
import Modelo.Avatar;
import Modelo.AvatarLista;
import Modelo.Objetos.Usuario;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author hp
 */
public class PanelAvatar extends JPanel {

    public static PanelAvatar PNLAVATAR;
    private MenuPrincipal mnuPrincipal;
    private JLabel lbTipoNombre;
    private JLabel lbTipo;
    private JLabel lbNombreUsuario;
    private JButton btnAtrasTipo;
    private JButton btnAdelanteTipo;
    private JButton btnAtrasTipoNombre;
    private JButton btnAdelanteTipoNombre;
    private TextFieldPlaceHolder txtAvatar;
    private JButton btnGuardar;
    private BufferedImage image;
    private String tipo;
    private int indexTipoSelecciona = -1;
    private HashMap<String, TipoParte> TipoPartes;
    private TipoParte tipoSeleccionado;
    private int indexTipoNombreSelecc = -1;
    private Avatar Avatar;

    //singleton
    public static JPanel getInstance(MenuPrincipal mnuprincipal) {
        PNLAVATAR = new PanelAvatar(mnuprincipal);
        return PNLAVATAR;
    }

    public PanelAvatar(MenuPrincipal mnuPrincipal) {
        this.mnuPrincipal = mnuPrincipal;
        Color fondo = new Color(232, 255, 255);
        this.setBackground(fondo);
        this.setBounds(0, 0, 900, 850);
        this.setVisible(true);
        this.setLayout(null);

        // boton atras abajo
        Usuario usuario = Usuario.Usuariolog;
        Avatar = new Avatar(usuario, "defaul");

        lbNombreUsuario = new JLabel();
        lbNombreUsuario.setText(usuario.getNombre());
        lbNombreUsuario.setBounds(230, 30, 200, 80);

        this.add(lbNombreUsuario);

        try {
            image = ImageIO.read(new File("./Images/body.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //cargamos los combos
        setMenuTipo();
        setMenuTipoNombres();
        AvanzarTipos();
        Guardar();
        this.repaint();
    }

    ////pintamos la base
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 100, 85, 300, 650, null);
        Avatar.paint(g);

    }

    public void AvanzarTipos() {
        indexTipoSelecciona++;
        if (indexTipoSelecciona == ParteDelCuerpo.TIPOS_PARTE.length) {
            indexTipoSelecciona = 0;
        }
        ///obtenemos la parte
        tipo = ParteDelCuerpo.TIPOS_PARTE[indexTipoSelecciona];
        //obtener las partes
        TipoPartes = ParteDelCuerpo.getPartes(tipo);
        lbTipoNombre.setText(tipo);
        //movemos las partes
        List<String> indexes = new ArrayList<>(TipoPartes.keySet());
        indexTipoNombreSelecc = indexes.indexOf(Avatar.getParte(tipo)) - 1;
        //se mueve los nombres de la parte imagenes
        AvanzarTipoNombre();

    }

    public void RetrocederTipos() {
        indexTipoSelecciona--;
        if (indexTipoSelecciona < 0) {
            indexTipoSelecciona = ParteDelCuerpo.TIPOS_PARTE.length - 1;
        }
        tipo = ParteDelCuerpo.TIPOS_PARTE[indexTipoSelecciona];
        //obtener las partes
        TipoPartes = ParteDelCuerpo.getPartes(tipo);
        lbTipoNombre.setText(tipo);
        //movemos las partes
        List<String> indexes = new ArrayList<>(TipoPartes.keySet());
        indexTipoNombreSelecc = indexes.indexOf(Avatar.getParte(tipo)) - 1;
        //se mueve los nombres de la parte imagenes
        AvanzarTipoNombre();

    }

    public void AvanzarTipoNombre() {
        indexTipoNombreSelecc++;
        if (TipoPartes.size() <= 0) {
            lbTipo.setText("Sin imagenes cargadas");
            return;
        }
        if (indexTipoNombreSelecc == TipoPartes.size()) {
            indexTipoNombreSelecc = 0;
        }
        List<String> indexes = new ArrayList<>(TipoPartes.keySet());
        ///nombres de las partes imagenes
        tipoSeleccionado = TipoPartes.get(indexes.get(indexTipoNombreSelecc));
        //ingresando la parte al avatar
        Avatar.setParte(tipoSeleccionado.getParte(), tipoSeleccionado.getNombre());
        lbTipo.setText(tipoSeleccionado.getNombre());

    }

    public void RetrocederTipoNombre() {
        indexTipoNombreSelecc--;
        if (TipoPartes.size() <= 0) {
            lbTipo.setText("Sin imagenes cargadas");
            return;
        }
        if (indexTipoNombreSelecc < 0) {
            indexTipoNombreSelecc = TipoPartes.size() - 1;
        }
        List<String> indexes = new ArrayList<>(TipoPartes.keySet());
        tipoSeleccionado = TipoPartes.get(indexes.get(indexTipoNombreSelecc));
        Avatar.setParte(tipoSeleccionado.getParte(), tipoSeleccionado.getNombre());  ///obtenemos la parte a cargar
        lbTipo.setText(tipoSeleccionado.getNombre());
    }

    public void setVentanaPrincipal(MenuPrincipal mnuPrincipal) {
        this.mnuPrincipal = mnuPrincipal;
    }

    public void setMenuTipo() {
        // boton atras arriba

        btnAtrasTipo = new JButton("prev");
        btnAtrasTipo.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnAtrasTipo.setBackground(new Color(54, 60, 70));
        btnAtrasTipo.setBounds(450, 20, 120, 60);
        btnAtrasTipo.setForeground(Color.white);
        btnAtrasTipo.setUI(new StyledButtonUI());

        btnAtrasTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                RetrocederTipos();
                repaint();
            }
        });
        this.add(btnAtrasTipo);
        // boton adelante arriba

        btnAdelanteTipo = new JButton("next");
        btnAdelanteTipo.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnAdelanteTipo.setBackground(new Color(54, 60, 70));
        btnAdelanteTipo.setBounds(730, 20, 120, 60);
        btnAdelanteTipo.setForeground(Color.white);
        btnAdelanteTipo.setUI(new StyledButtonUI());

        btnAdelanteTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AvanzarTipos();
                repaint();
            }
        });
        this.add(btnAdelanteTipo);
        this.tipo = ParteDelCuerpo.PARTE_ROPA;

        // etiqueta Categoria
        lbTipoNombre = new JLabel();
        lbTipoNombre.setText(tipo);
        lbTipoNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lbTipoNombre.setVerticalAlignment(SwingConstants.CENTER);
        lbTipoNombre.setBounds(520, 20, 260, 60);
        this.add(lbTipoNombre);
    }

    public void setMenuTipoNombres() {

        btnAtrasTipoNombre = new JButton("prev");
        btnAtrasTipoNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnAtrasTipoNombre.setBackground(new Color(54, 60, 70));
        btnAtrasTipoNombre.setBounds(450, 120, 120, 60);
        btnAtrasTipoNombre.setForeground(Color.white);
        btnAtrasTipoNombre.setUI(new StyledButtonUI());

        btnAtrasTipoNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                RetrocederTipoNombre();
                repaint();
            }
        });
        this.add(btnAtrasTipoNombre);
        // boton adelante abajo

        btnAdelanteTipoNombre = new JButton("next");
        btnAdelanteTipoNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnAdelanteTipoNombre.setBackground(new Color(54, 60, 70));
        btnAdelanteTipoNombre.setBounds(730, 120, 120, 60);
        btnAdelanteTipoNombre.setForeground(Color.white);
        btnAdelanteTipoNombre.setUI(new StyledButtonUI());

        btnAdelanteTipoNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AvanzarTipoNombre();
                repaint();
            }
        });
        this.add(btnAdelanteTipoNombre);

        // etiqueta Tipo
        lbTipo = new JLabel();
        lbTipo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTipo.setVerticalAlignment(SwingConstants.CENTER);
        lbTipo.setBounds(520, 120, 260, 60);
        this.add(lbTipo);
    }

    private boolean validaNombreAvatar(String nombreAvatar) {
        boolean exito = true;
        if (nombreAvatar.length() <= 0) {
            exito = false;
        }
        if (exito) {
            Avatar.setNombre(nombreAvatar);
            return true;
        }
        return false;
    }

    public void Guardar() {

        txtAvatar = new TextFieldPlaceHolder();
        txtAvatar.setBounds(590, 250, 120, 50);
        txtAvatar.setPlaceholder("Nombre Avatar");

        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Calibri", Font.PLAIN, 14));
        btnGuardar.setBackground(new Color(54, 60, 70));
        btnGuardar.setBounds(590, 320, 120, 50);
        btnGuardar.setForeground(Color.white);
        btnGuardar.setUI(new StyledButtonUI());

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // RetrocederCategoria();
                boolean next = validaNombreAvatar(txtAvatar.getText());
                if (next) {
                    AvatarLista.setAvatar(Avatar);
                    Usuario usuario = Usuario.Usuariolog;
                    txtAvatar.setText("");
                    Avatar = new Avatar(usuario, "defaul");

                    //mnuPrincipal.cargaPanel(PanelAvatarList.getInstance(mnuPrincipal));
                    repaint();
                } else {
                    showMessageDialog(null, "Avatar sin nombre");
                }
            }
        });
        this.add(txtAvatar);
        this.add(btnGuardar);
    }

}
