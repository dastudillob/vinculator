package chamorro.trabajo.Entidades;


import java.io.Serializable;
import java.util.Date;

public class Contacto implements Serializable {
    private String num_telef;
    private String nom;
    private Date fecha;

    public Contacto() {
    }

    public Contacto(String num_telef, String nom, Date fecha) {
        this.num_telef = num_telef;
        this.nom = nom;
        this.fecha = fecha;
    }

    public String getNum_telef() {
        return num_telef;
    }

    public void setNum_telef(String num_telef) {
        this.num_telef = num_telef;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
