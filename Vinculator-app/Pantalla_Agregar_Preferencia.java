package chamorro.trabajo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import chamorro.trabajo.Utilidades.Utilidades;


public class Pantalla_Agregar_Preferencia extends AppCompatActivity {
    CheckBox comida,cine,musica,otros;
    String numero;
    BDHelper conn;
    TextView texto_pref;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_agregar_pref);
        comida = (CheckBox) findViewById(R.id.checkComida);
        cine = (CheckBox) findViewById(R.id.checkCine);
        musica = (CheckBox) findViewById(R.id.checkMusica);
        otros = (CheckBox) findViewById(R.id.checkOtros);
        texto_pref= (TextView) findViewById(R.id.txt_preferencia);
        Bundle mibundle;
        mibundle = this.getIntent().getExtras();
        numero = mibundle.getString("numero_telefonito");
        conn = new BDHelper(this,"bd_vinculator",null,1);

    }
    public void aceptar_agregar_pref(View v){
        SQLiteDatabase db = conn.getWritableDatabase();
        if(texto_pref.getText().toString().isEmpty() || (comida.isChecked() == false) && (cine.isChecked() == false) && (musica.isChecked()==false) &&(otros.isChecked()==false)){
            Toast.makeText(getApplicationContext(),"DEBE SELECCIONAR UNA CATEGORÍA Y ESCRIBIR UNA PREFERENCIA",Toast.LENGTH_LONG).show();
        }else {
            try{
                if (comida.isChecked()) {
                    //insert into preferencia (cod_cat,gusto,num_telef) values();
                    String sql = "INSERT INTO " + Utilidades.Tabla_preferencia + " (" + Utilidades.Campo_codcat + "," + Utilidades.Campo_gusto + "," + Utilidades.Campo_telef + ") VALUES('CO', '" + texto_pref.getText().toString() + "', '" + numero + "')";

                    db.execSQL(sql);
                    Toast.makeText(getApplicationContext(),"SU PREFERENCIA FUE AGREGADA CORRECTAMENTE",Toast.LENGTH_LONG).show();
                    db.close();
                }
                if (cine.isChecked()) {
                    //insert into preferencia (cod_cat,gusto,num_telef) values();
                    String sql = "INSERT INTO " + Utilidades.Tabla_preferencia + " (" + Utilidades.Campo_codcat + "," + Utilidades.Campo_gusto + "," + Utilidades.Campo_telef + ") VALUES('CI', '" + texto_pref.getText().toString() + "', '" + numero + "')";

                    db.execSQL(sql);
                    Toast.makeText(getApplicationContext(),"SU PREFERENCIA FUE AGREGADA CORRECTAMENTE",Toast.LENGTH_LONG).show();
                    db.close();
                }
                if (musica.isChecked()) {
                    //insert into preferencia (cod_cat,gusto,num_telef) values();
                    String sql = "INSERT INTO " + Utilidades.Tabla_preferencia + " (" + Utilidades.Campo_codcat + "," + Utilidades.Campo_gusto + "," + Utilidades.Campo_telef + ") VALUES('MU', '" + texto_pref.getText().toString() + "', '" + numero + "')";

                    db.execSQL(sql);
                    Toast.makeText(getApplicationContext(),"SU PREFERENCIA FUE AGREGADA CORRECTAMENTE",Toast.LENGTH_LONG).show();
                    db.close();
                }
                if (otros.isChecked()) {
                    //insert into preferencia (cod_cat,gusto,num_telef) values();
                    String sql = "INSERT INTO " + Utilidades.Tabla_preferencia + " (" + Utilidades.Campo_codcat + "," + Utilidades.Campo_gusto + "," + Utilidades.Campo_telef + ") VALUES('OT', '" + texto_pref.getText().toString() + "', '" + numero + "')";

                    db.execSQL(sql);
                    Toast.makeText(getApplicationContext(),"SU PREFERENCIA FUE AGREGADA CORRECTAMENTE",Toast.LENGTH_LONG).show();
                    db.close();
                }


            }

            catch (Exception e){
                Toast.makeText(getApplicationContext(),"YA EXISTE ESTA PREFERENCIA",Toast.LENGTH_LONG).show();
                db.close();
            }
        }
    }
   public void ValidarChequeo(View v){
       if (comida.isChecked()){
           cine.setChecked(false);
           musica.setChecked(false);
           otros.setChecked(false);
       }
       if(cine.isChecked()){
           comida.setChecked(false);
           musica.setChecked(false);
           otros.setChecked(false);
       }
       if(musica.isChecked()){
           comida.setChecked(false);
           cine.setChecked(false);
           otros.setChecked(false);
       }
       if(otros.isChecked()){
           comida.setChecked(false);
           cine.setChecked(false);
           musica.setChecked(false);
       }
   }

}
