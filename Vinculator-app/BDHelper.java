package chamorro.trabajo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import chamorro.trabajo.Utilidades.Utilidades;


public class BDHelper extends SQLiteOpenHelper {

    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.Crear_Tabla_Contacto);
        db.execSQL(Utilidades.Crear_Tabla_Categoria);
        db.execSQL(Utilidades.Crear_Tabla_Encuesta);
        db.execSQL(Utilidades.Crear_Tabla_Preferencia);
        String sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Dónde desearías vivir?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Dónde desearía vivir?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué lugar te gustaría visitar?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué lugar le gustaría visitar?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Te consideras ordenado o desordenado?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Lo consideras ordenado o desordenado?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué tipo de ropa te gusta más?//poleras, pantalones, chaqueta, chaleco, poleron, etc.')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué tipo de ropa le gusta más?//poleras, pantalones, chaqueta, chaleco, poleron, etc.')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Cuál es tú banda musical favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Cuál es su banda musical favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Qué tipo de música te gusta más?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Qué tipo de música le gusta más?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué aspecto te gusta más de ti?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué aspecto te gusta más de él/ella?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cuál es tú libro favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cuál es su libro favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué súper poder tendrías?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué súper poder tendría?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CI','¿Cuál es tú serie favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CI','¿Cuál es su serie favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CI','¿Cuál es tú género cinematográfico favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CI','¿Cuál es su género cinematográfico favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Color favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cúal es su color favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué aspecto físico te gusta más en una persona?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué aspecto físico le gusta más en una persona?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué aspecto psicológico te gusta más en una persona?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué aspecto psicológico le gusta más en una persona?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cuál es tú animal favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cuál es su animal favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Canción favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Cúal es su canción favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Canción más escuchada?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Canción que más escucha?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué profesión te gustaría ejercer?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué profesión le gustaría ejercer?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué habilidad te gustaría perfeccionar?//Cocinar,en Deportes,etc.')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Qué habilidad le gustaría perfeccionar?//Cocinar,en Deportes,etc.')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿A que le tienes miedo?//Respuesta debe ser: Miedo a..')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿A que le tiene miedo?//Respuesta debe ser: Miedo a..')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Qué tipo de música te gusta escuchar?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Qué tipo de música le gusta escuchar?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Qué tipo de música te gusta bailar?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('MU','¿Qué tipo de música le gusta bailar?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es tú comida favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es su comida favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es tú bebida gaseosa favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es su bebida gaseosa favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es tú bebida alcohólica favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es su bebida alcohólica favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es tú fruta favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es su fruta favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es tú postre favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es su postre favorito?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es tú ensalada favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('CO','¿Cuál es su ensalada favorita?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cuál es tú signo zodiacal?')";
        db.execSQL(sql);
        sql = "INSERT INTO encuesta (cod_cat,pregunta) VALUES('OT','¿Cuál es su signo zodiacal?')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacto");
        db.execSQL("DROP TABLE IF EXISTS categoria");
        db.execSQL("DROP TABLE IF EXISTS encuesta");
        db.execSQL("DROP TABLE IF EXISTS preferencia");
        onCreate(db);
    }
}
