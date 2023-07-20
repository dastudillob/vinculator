package chamorro.trabajo.Entidades;


import java.io.Serializable;

public class Preferencia {
    private int cod_pref;
    private String cod_cat;
    private String num_telef;
    private String gusto;

    public Preferencia() {
    }

    public Preferencia(int cod_pref, String cod_cat, String num_telef, String gusto) {
        this.cod_pref = cod_pref;
        this.cod_cat = cod_cat;
        this.num_telef = num_telef;
        this.gusto = gusto;
    }

    public int getCod_pref() {
        return cod_pref;
    }

    public void setCod_pref(int cod_pref) {
        this.cod_pref = cod_pref;
    }

    public String getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(String cod_cat) {
        this.cod_cat = cod_cat;
    }

    public String getNum_telef() {
        return num_telef;
    }

    public void setNum_telef(String num_telef) {
        this.num_telef = num_telef;
    }

    public String getGusto() {
        return gusto;
    }

    public void setGusto(String gusto) {
        this.gusto = gusto;
    }
}
