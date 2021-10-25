/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Objetos;

import Modelo.ProcesaParte;
import Modelo.TipoParte;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author hp
 */

public class Ropa implements ProcesaParte {
    private TipoParte ropa; ///este tipo de parte sabemos que es el modelo objeto boca
    private BufferedImage image;
    
    public static final int x= 34;
    public static final int y = 210;
    public static final int w = 423;
    public static final int h = 500;

    public Ropa(TipoParte ropa) {
        this.ropa = ropa;
        try {
            image = ImageIO.read(new File(ropa.getUrl()));
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
        return ropa;
    }

}
