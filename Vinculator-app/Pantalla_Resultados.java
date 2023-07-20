package chamorro.trabajo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import org.w3c.dom.Text;

import chamorro.trabajo.Utilidades.Utilidades;


public class Pantalla_Resultados extends AppCompatActivity {
    String nombre;
    int puntos,total = 0,porcentaje_final,aciertos = 0,fallos = 0;
    BDHelper conn;
    Puntitos personas = new Puntitos();
    private DonutProgress donutProgress;
    TextView frasecita,nivelcito,acierto,fallo;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_resultados);
        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        Bundle mibundle;
        mibundle = this.getIntent().getExtras();
        frasecita = (TextView) findViewById(R.id.txt_frase);
        nivelcito = (TextView) findViewById(R.id.txt_nivel);
        acierto = (TextView) findViewById(R.id.txt_acierto);
        fallo = (TextView) findViewById(R.id.txt_fallo);
        conn = new BDHelper(this,"bd_vinculator",null,1);
        personas = (Puntitos) mibundle.getSerializable("nombre_contacto");
        nombre= personas.getNombre();
        puntos = personas.getPuntos();
        CantidadPreguntas();
        total = total/2;
        aciertos = puntos;
        fallos = total - aciertos;
        porcentaje_final = (100*puntos)/total;
        donutProgress.setProgress(porcentaje_final);
        MostrarFrase();
        acierto.setText("ACIERTOS: "+aciertos);
        fallo.setText("FALLOS: "+fallos);

    }

    private void MostrarFrase() {
        if ((porcentaje_final >= 0) &&(porcentaje_final <25)  ){
            nivelcito.setText("RECIEN CONOCIDOS");
            frasecita.setText("LLEVAN POCO TIEMPO HABLANDO. TIENEN UN GRAN CAMINO POR RECORRER JUNTOS, MUCHAS AVENTURAS POR VIVIR Y CONVERSACIONES GENIALES. ");
        }
        if ((porcentaje_final >= 25) &&(porcentaje_final <50)  ){
            nivelcito.setText("CONOCIDOS");
            frasecita.setText("SE CONOCEN DESDE HACE MUCHO A PESAR DE QUE NO HABLEN TAN SEGUIDO, SE APRECIAN MUTUAMENTE Y SE LLEVAN BIEN CUANDO ESTAN JUNTOS. ES MOMENTO DE QUE EMPIECEN A VERSE MÁS PARA ESTABLECER LO QUE PUEDE LLEGAR A SER, UNA GRAN AMISTAD. ");
        }
        if ((porcentaje_final >= 50) &&(porcentaje_final <75)  ){
            nivelcito.setText("AMIGOS");
            frasecita.setText("HABLAN SEGUIDO, LO CONOCES BIEN. HAN PASADO MUCHAS EXPERIENCIAS JUNTOS Y AÚN QUEDAN MUCHAS POR VIVIR, SI SABES TANTO DE ESTA PERSONA SEGURO QUE ÉL/ELLA TE MIRA COMO ALGUIEN DE CONFIANZA, SIGUE ASÍ");
        }
        if ((porcentaje_final >= 75) &&(porcentaje_final <100)  ){
            nivelcito.setText("MEJORES AMIGOS / HERMANOS");
            frasecita.setText("LO CONOCES DE MANERA CASI PERFECTA, PASAN MUCHO TIEMPO HABLANDO, DISFRUTAN AL MÁXIMO CADA SEGUNDO JUNTOS. AÚN ASI FALLASTE EN UN PUNTO, LO QUE DEMUESTRA QUE TE FALTA UN POCO MÁS POR CONOCER A ESTA PERSONA, NO ES GENIAL?, TODAVÍA HAY MÁS PARTES QUE PUEDES LLEGAR A QUERER DE ESTA PERSONA.");
        }
        if ((porcentaje_final == 100)){
            nivelcito.setText("ALMA GEMELA");
            frasecita.setText("ACERTASTE TODAS LAS PREGUNTAS, LO CONOCES DE MANERA PERFECTA, LA CONFIANZA QUE TE TIENE ESTA PERSONA ES MUY GRANDE, DEBERIAS SENTIRTE MUY APRECIADO Y QUERIDO POR ÉL/ELLA");
        }
    }

    public void CantidadPreguntas() {
        int indice=0;

        SQLiteDatabase db = conn.getReadableDatabase();
        String sql = "SELECT * FROM "+Utilidades.Tabla_encuesta;
        try{
            Cursor cursor = db.rawQuery(sql,null);

            while(cursor.moveToNext()){
                    indice=cursor.getInt(0);
                    total = indice;

            }
            db.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();
            db.close();
        }


    }

}

