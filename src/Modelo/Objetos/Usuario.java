package Modelo.Objetos;

import java.util.HashMap;

/**
 *
 * @author hp
 */

public class Usuario {

    
    ///usuario logeado
    public static Usuario Usuariolog;
    public static HashMap<String, Usuario> Usuarios = new HashMap<>();
    
    private String nombre;
    private String usuario;
    private String password;

    public Usuario(String nombre, String usuario, String pass) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = pass;
        ///el nombre del usuario es la llave
        Usuarios.put(this.usuario, this);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Usuario: " + getUsuario();
    }
}
