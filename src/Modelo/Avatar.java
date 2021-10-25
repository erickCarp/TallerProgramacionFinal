/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Objetos.Usuario;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;


/**
 *
 * @author hp
 */

public class Avatar {

    private String nombre;
    private Usuario usuario;
    
    ////listas de partes
    private HashMap<String, ProcesaParte> partes;

    public Avatar(Usuario usuario, String nombre) {
        this.nombre = nombre;
        this.usuario = usuario;   
        avatarBase();///cargamos el avatar por defecto
    }
    
    //colocamos las partes al avatar
    public void setParte(String tipoParte, String parteLlave) {
        TipoParte tipoParteTemp = ParteDelCuerpo.getPartes(tipoParte).get(parteLlave);  ///obtenemos el tipo parte para ingresar a la lista de partes del avatar
        ProcesaParte parte = ParteDelCuerpo.colocaParte(tipoParteTemp);  ///aca asignamos la parte de la lista y retornamos cual
        partes.put(tipoParteTemp.getParte(), parte);  ///de esa parte traemos su nombre osea ojo boca pantalon
    }

    ///obtenemos una parte de la lista por su tipo si es ojo boca
    public String getParte(String nombreParte) {
        ProcesaParte parte = partes.get(nombreParte);///devuelve ojo boca pantalon
        if (parte == null) {
            return "";
        }
        return parte.getParte().getNombre(); //devolvemos el nombre de la parte osea ojo1
    }

    ////pintamos las partes
    public void paint(Graphics g) {
        for (Map.Entry me : partes.entrySet()) { //recorremos la lista hash
            partes.get(me.getKey()).paint(g); ///pintamos la parte
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void avatarBase(){
        partes = new HashMap<>();
        // INSTACIAMOS NUESTRO AVATAR POR DEFECTO
        
        setParte(ParteDelCuerpo.PARTE_CABELLO, "ninguno");
        setParte(ParteDelCuerpo.PARTE_CEJA, "ninguno");
        setParte(ParteDelCuerpo.PARTE_OJO, "ninguno");
        setParte(ParteDelCuerpo.PARTE_NARIZ, "ninguno");
        setParte(ParteDelCuerpo.PARTE_BOCA, "ninguno");
        setParte(ParteDelCuerpo.PARTE_ROPA, "ninguno");
    }

    @Override
    public String toString() {
        // usuarioCreador.getUsuario();
        return "Nombre creacion: " + this.getNombre() + " Usuario: " + usuario.getUsuario();
    }

}
