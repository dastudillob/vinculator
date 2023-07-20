package chamorro.trabajo.Utilidades;


public class Utilidades {

    public static final String Crear_Tabla_Contacto = "CREATE TABLE contacto(num_telef TEXT PRIMARY KEY NOT NULL,nom TEXT,fecha_nac DATE)";
    //constantes tabla contacto
    public static final String Tabla_Contacto = "contacto";
    public static final String Campo_telef = "num_telef";
    public static final String Campo_nom = "nom";
    public static final String Campo_fecha_nac = "fecha_nac";
    //constantes tabla categoria
    public static final String Crear_Tabla_Categoria = "CREATE TABLE categoria(cod_cat TEXT PRIMARY KEY NOT NULL,nom_cat TEXT)";
    public static final String Tabla_categoria = "categoria";
    public static final String Campo_codcat = "cod_cat";
    public static final String Campo_nomcat = "nom_cat";
    //constantes tabla encuesta
    public static final String Crear_Tabla_Encuesta = "CREATE TABLE encuesta(cod_pr INTEGER PRIMARY KEY AUTOINCREMENT,cod_cat TEXT REFERENCES categoria(cod_cat),pregunta TEXT)";
    public static final String Tabla_encuesta = "encuesta";
    public static final String Campo_codpr = "cod_pr";
    public static final String Campo_pregunta = "pregunta";
    //constantes tabla preferencias
    public static final String Crear_Tabla_Preferencia = "CREATE TABLE preferencia(cod_pref INTEGER PRIMARY KEY AUTOINCREMENT,cod_cat TEXT,gusto TEXT,num_telef TEXT)";
    public static final String Tabla_preferencia = "preferencia";
    public static final String Campo_codpref = "cod_pref";
    public static final String Campo_gusto = "gusto";
}
