package chamorro.trabajo;

import java.io.Serializable;

/**
 * Created by Daniel on 25-09-2017.
 */

public class Puntitos implements Serializable{
    private String nombre;
    private int puntos;

    public Puntitos() {
    }

    public Puntitos(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
