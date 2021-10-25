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

public class Ojos implements ProcesaParte {
    private TipoParte ojos; ///sabemos que es el tipoparte ojos
    private BufferedImage image; 
    
    ///no cambiara las posiciones
    public static final int x= 164;
    public static final int y = 149;
    public static final int w = 150;
    public static final int h = 53;
    

    public Ojos(TipoParte ojos) {
        this.ojos = ojos;
        try {
            image = ImageIO.read(new File(ojos.getUrl()));
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
        return ojos;
    }

}
