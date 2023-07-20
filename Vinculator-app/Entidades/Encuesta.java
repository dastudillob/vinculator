package chamorro.trabajo.Entidades;



public class Encuesta {
    private int cod_pr;
    private String cod_cat;
    private String pregunta;

    public Encuesta() {
    }

    public Encuesta(byte cod_pr, String cod_cat, String pregunta) {
        this.cod_pr = cod_pr;
        this.cod_cat = cod_cat;
        this.pregunta = pregunta;
    }

    public int getCod_pr() {
        return cod_pr;
    }

    public void setCod_pr(int cod_pr) {
        this.cod_pr = cod_pr;
    }

    public String getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(String cod_cat) {
        this.cod_cat = cod_cat;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
