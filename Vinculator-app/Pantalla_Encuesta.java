package chamorro.trabajo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import chamorro.trabajo.Entidades.Contacto;
import chamorro.trabajo.Entidades.Encuesta;
import chamorro.trabajo.Utilidades.Utilidades;


public class Pantalla_Encuesta extends AppCompatActivity {
    String respuesta1,respuesta2,categoria,numero; //respuesta1 es la que pone el usuario, respuesta2 es la que pone el contacto
    int Turno = 1,puntos,indice; //turno = 0 le toca al usuario, turno = 1 le toca al contacto
    EditText txt_respuesta;
    TextView pregunta,turnousuario,turnocontacto;
    BDHelper conn;
    Button boton;
    Contacto contacto = new Contacto();
    Encuesta encuesta = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_encuesta);
        txt_respuesta = (EditText) findViewById(R.id.respuesta);
        pregunta = (TextView) findViewById(R.id.lbl_pregunta);
        turnousuario = (TextView) findViewById(R.id.lbl_turno);
        turnocontacto = (TextView) findViewById(R.id.lbl_turno2);
        conn = new BDHelper(this, "bd_vinculator", null, 1);
        Bundle mibundle;
        mibundle = this.getIntent().getExtras();
        contacto = (Contacto) mibundle.getSerializable("contactito");
        puntos = 0;
        turnousuario.setText("Turno de: ");
        turnocontacto.setText(contacto.getNom());
        indice= 1;
        numero = contacto.getNum_telef();
        CargarPreguntas();



    }



    private void CargarPreguntas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        String sql = "SELECT "+Utilidades.Campo_codpr+", "+ Utilidades.Campo_codcat+", "+Utilidades.Campo_pregunta+" FROM "+Utilidades.Tabla_encuesta+" WHERE "+Utilidades.Campo_codpr+" = "+indice;
        try{
            Cursor cursor = db.rawQuery(sql,null);
            if(cursor.moveToFirst()){
                encuesta = new Encuesta();
                encuesta.setCod_pr(cursor.getInt(0));
                encuesta.setCod_cat(cursor.getString(1));
                categoria = encuesta.getCod_cat();
                encuesta.setPregunta(cursor.getString(2));
               pregunta.setText(encuesta.getPregunta());
                indice++;
                txt_respuesta.setText("");
                db.close();
            }
            else{
                db.close();
                iraresultado();

            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();
            db.close();
        }


    }


    public void iraresultado(){
        Intent i = new Intent(this,Pantalla_Resultados.class);
        Puntitos persona = new Puntitos();
        Bundle mibundle = new Bundle();
        persona.setNombre(contacto.getNom());
        persona.setPuntos(puntos);
        mibundle.putSerializable("nombre_contacto",persona);
        i.putExtras(mibundle);
        finish();
        startActivity(i);
    }


    private void guardarRespuesta(String respuesta,String categoria, String numero){
        SQLiteDatabase db = conn.getWritableDatabase();

                try{
                    //insert into preferencia (cod_cat,gusto,num_telef) values();
                    String sql = "INSERT INTO "+ Utilidades.Tabla_preferencia+" ("+Utilidades.Campo_codcat+","+Utilidades.Campo_gusto+","+Utilidades.Campo_telef+") VALUES('"+categoria+"','"+respuesta+"','"+numero+"')";
                    db.execSQL(sql);
                    db.close();
                }

                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"error"+e,Toast.LENGTH_LONG).show();
                    db.close();
                }


    }
   public void responderEncuesta(View vista){
       if (txt_respuesta.getText().toString().isEmpty()){
           Toast.makeText(getApplicationContext(),"DEBE INGRESAR UNA RESPUESTA",Toast.LENGTH_LONG).show();
       }else{
           if (Turno == 1){
               categoria = encuesta.getCod_cat();
               respuesta1 = txt_respuesta.getText().toString();
               turnousuario.setText("Tu Turno");
               turnocontacto.setText(" ");
               Turno = 0;
               CargarPreguntas();

               guardarRespuesta(respuesta1,categoria,numero);
           }
           else{
               respuesta2 = txt_respuesta.getText().toString();
               turnousuario.setText("Turno de: ");
               turnocontacto.setText(contacto.getNom());
               if (respuesta1.toUpperCase().equals(respuesta2.toUpperCase())) {
                   puntos++;
               }
               CargarPreguntas();
               Turno = 1;
           }
       }


   }
 }


