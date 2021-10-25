/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Objetos.Boca;
import Modelo.Objetos.Cabello;
import Modelo.Objetos.Cejas;
import Modelo.Objetos.Nariz;
import Modelo.Objetos.Ojos;
import Modelo.Objetos.Ropa;
import java.util.HashMap;

/**
 *
 * @author hp
 */

public class ParteDelCuerpo {
    
    //Lista de partes del cuerpo
    
    public static HashMap<String, TipoParte> tipoCabello = new HashMap<>();
    public static HashMap<String, TipoParte> tipoCeja = new HashMap<>();
    public static HashMap<String, TipoParte> tipoOjos = new HashMap<>();
    public static HashMap<String, TipoParte> tipoNariz = new HashMap<>();
    public static HashMap<String, TipoParte> tipoBoca = new HashMap<>();
    public static HashMap<String, TipoParte> tipoRopa = new HashMap<>();
    
    ///usado adentro para saber el tipo
    public static final String PARTE_CABELLO = "cabello";
    public static final String PARTE_CEJA = "ceja";
    public static final String PARTE_OJO = "ojos";
    public static final String PARTE_NARIZ = "nariz";
    public static final String PARTE_BOCA = "boca";
    public static final String PARTE_ROPA = "ropa";
    
    ///lista de categoria
    public static final String[] TIPOS_PARTE = { PARTE_CABELLO, PARTE_CEJA, PARTE_OJO, PARTE_NARIZ, PARTE_BOCA, PARTE_ROPA}; //usado afuera

    public static ProcesaParte colocaParte(TipoParte parte) {
        switch (parte.getParte()) {
            case PARTE_CABELLO:
                return new Cabello(parte);
            case PARTE_CEJA:
                return new Cejas(parte);
            case PARTE_OJO:
                return new Ojos(parte);
            case PARTE_NARIZ:
                return new Nariz(parte);
            case PARTE_BOCA:
                return new Boca(parte);
            case PARTE_ROPA:
                return new Ropa(parte);
        }
        return null;
    }
    
    ///llenamos las partes Hash con el estilo
    public static TipoParte setTipoParte(TipoParte tipoParte) {
        switch (tipoParte.getParte()) {
            case ParteDelCuerpo.PARTE_CABELLO:
                ParteDelCuerpo.tipoCabello.put(tipoParte.getNombre(), tipoParte);
                break;
            case ParteDelCuerpo.PARTE_CEJA:
                ParteDelCuerpo.tipoCeja.put(tipoParte.getNombre(), tipoParte);
                break;
            case ParteDelCuerpo.PARTE_OJO:
                ParteDelCuerpo.tipoOjos.put(tipoParte.getNombre(), tipoParte);
                break;
            case ParteDelCuerpo.PARTE_NARIZ:
                ParteDelCuerpo.tipoNariz.put(tipoParte.getNombre(), tipoParte);
                break;
            case ParteDelCuerpo.PARTE_BOCA:
                ParteDelCuerpo.tipoBoca.put(tipoParte.getNombre(), tipoParte);
                break;            
            case ParteDelCuerpo.PARTE_ROPA:
                ParteDelCuerpo.tipoRopa.put(tipoParte.getNombre(), tipoParte);
                break;
            
            
        }
        return null;
    }
    
    ///devolvemos todas las listas hash
    public static HashMap<String, TipoParte> getPartes(String tipo) {
        switch (tipo) {
            case ParteDelCuerpo.PARTE_BOCA:
                return ParteDelCuerpo.tipoBoca;
            case ParteDelCuerpo.PARTE_OJO:
                return ParteDelCuerpo.tipoOjos;
            case ParteDelCuerpo.PARTE_ROPA:
                return ParteDelCuerpo.tipoRopa;
            case ParteDelCuerpo.PARTE_CABELLO:
                return ParteDelCuerpo.tipoCabello;
            case ParteDelCuerpo.PARTE_NARIZ:
                return ParteDelCuerpo.tipoNariz;
            case ParteDelCuerpo.PARTE_CEJA:
                return ParteDelCuerpo.tipoCeja;
        }
        return null;
    }
}
