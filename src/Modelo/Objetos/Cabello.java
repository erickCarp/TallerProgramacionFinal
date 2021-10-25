/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Objetos;

import Modelo.ProcesaParte;
import Modelo.TipoParte;
import static Modelo.Objetos.Boca.h;
import static Modelo.Objetos.Boca.w;
import static Modelo.Objetos.Boca.x;
import static Modelo.Objetos.Boca.y;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author hp
 */

public class Cabello implements ProcesaParte {
    private TipoParte cabello;  ///sabemos que viene de tipoparte cabello
    private BufferedImage image;
    
    public static final int x= 159;
    public static final int y = 70;
    public static final int w = 162;
    public static final int h = 200;
    
    public Cabello(TipoParte cabello) {
        this.cabello = cabello;
        try {
            image = ImageIO.read(new File(cabello.getUrl()));
        } catch (IOException e) {
            image = null;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (image != null) {
           g.drawImage(image, x, y, w,h, null);
        }
    }

    @Override
    public TipoParte getParte() {
        return cabello;
    }

}
