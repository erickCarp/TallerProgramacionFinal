/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avatares;

import Modelo.TipoParte;
import Modelo.ParteDelCuerpo;
import Vista.MenuPrincipal;

/**
 *
 * @author hp
 */
public class console {

    public static void main(String[] args) throws Exception {
        
        cargarPartes();
        
        MenuPrincipal mnuPrincipal = new MenuPrincipal();
    }

    public static void cargarPartes() {
        // cabello
        new TipoParte("ninguno", ParteDelCuerpo.PARTE_CABELLO, "");
        new TipoParte("Cabello1", ParteDelCuerpo.PARTE_CABELLO, "./Images/cabello1.png");
        new TipoParte("Cabello2", ParteDelCuerpo.PARTE_CABELLO, "./Images/cabello2.png");
        new TipoParte("Cabello3", ParteDelCuerpo.PARTE_CABELLO, "./Images/cabello3.png");
        // cejas
        new TipoParte("ninguno", ParteDelCuerpo.PARTE_CEJA, "");
        new TipoParte("ceja1", ParteDelCuerpo.PARTE_CEJA, "./Images/ceja1.png");
        new TipoParte("ceja2", ParteDelCuerpo.PARTE_CEJA, "./Images/ceja2.png");
        new TipoParte("ceja3", ParteDelCuerpo.PARTE_CEJA, "./Images/ceja3.png");
        // ojos
        new TipoParte("ninguno", ParteDelCuerpo.PARTE_OJO, "");
        new TipoParte("Ojo1", ParteDelCuerpo.PARTE_OJO, "./Images/ojo1.png");
        new TipoParte("Ojo2", ParteDelCuerpo.PARTE_OJO, "./Images/ojo2.png");
        new TipoParte("Ojo3", ParteDelCuerpo.PARTE_OJO, "./Images/ojo3.png");

        // bocas
        new TipoParte("ninguno", ParteDelCuerpo.PARTE_NARIZ, "");
        new TipoParte("nariz1", ParteDelCuerpo.PARTE_NARIZ, "./Images/nariz1.png");
        new TipoParte("nariz2", ParteDelCuerpo.PARTE_NARIZ, "./Images/nariz2.png");
        new TipoParte("nari13", ParteDelCuerpo.PARTE_NARIZ, "./Images/nariz3.png");

        // bocas
        new TipoParte("ninguno", ParteDelCuerpo.PARTE_BOCA, "");
        new TipoParte("Boca1", ParteDelCuerpo.PARTE_BOCA, "./Images/boca1.png");
        new TipoParte("Boca2", ParteDelCuerpo.PARTE_BOCA, "./Images/boca2.png");
        new TipoParte("Boca3", ParteDelCuerpo.PARTE_BOCA, "./Images/boca3.png");

        // ropa
        new TipoParte("ninguno", ParteDelCuerpo.PARTE_ROPA, "");
        new TipoParte("ropa1", ParteDelCuerpo.PARTE_ROPA, "./Images/ropa1.png");
        new TipoParte("ropa2", ParteDelCuerpo.PARTE_ROPA, "./Images/ropa2.png");
        new TipoParte("ropa3", ParteDelCuerpo.PARTE_ROPA, "./Images/ropa3.png");
    }
}
