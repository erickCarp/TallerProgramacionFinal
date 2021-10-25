/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author hp
 */

public class TipoParte {
    private String nombre;     //ojo1 ojo2 ojo3
    private String parte;  //// si es polera ojos cuerpo
    private String url;

    public TipoParte(String nombre, String parte, String url) {
        this.nombre = nombre;
        this.parte = parte;
        this.url = url;
        ParteDelCuerpo.setTipoParte(this);
    }

    public String getParte() {
        return parte;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
