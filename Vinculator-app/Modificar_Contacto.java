package chamorro.trabajo;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Calendar;

import chamorro.trabajo.Entidades.Contacto;
import chamorro.trabajo.Utilidades.Utilidades;


public class Modificar_Contacto extends AppCompatActivity {
    private int año;
    private int mes;
    private int dia;
    private static DatePickerDialog.OnDateSetListener selectorfecha;
    private static final int Tipo_dialogo = 0;
    Button boton_modificar;
    EditText texto_nombre,texto_num,texto_fecha;
    String numero;
    Contacto contacto;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_contacto);
        boton_modificar = (Button) findViewById(R.id.BTN_MODIFICAR);
        texto_nombre = (EditText) findViewById(R.id.TXT_EDITNOMBRE_C);
        texto_num = (EditText) findViewById(R.id.TXT_EDITNUM_TELEF);
        texto_fecha = (EditText) findViewById(R.id.TXT_EDITFECHA_C);
        contacto = new Contacto();
        final BDHelper mDbHelper = new BDHelper(this,"bd_vinculator",null,1);
        Bundle mibundle;
        mibundle = this.getIntent().getExtras();
        contacto = (Contacto) mibundle.getSerializable("numero_telefonito");
        texto_nombre.setText(contacto.getNom());
        texto_num.setText(contacto.getNum_telef());
        numero = contacto.getNum_telef();
        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        selectorfecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                dia = dayOfMonth;
                mostrarFecha();
            }


        };

        boton_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                if ((texto_nombre.getText().toString().isEmpty()) || (texto_num.getText().toString().isEmpty()) || (texto_fecha.getText().toString().isEmpty())){
                    Toast.makeText(getApplicationContext(),"TODOS LOS CAMPOS SON OBLIGATORIOS, VUELVA A INTENTARLO.",Toast.LENGTH_LONG).show();
                }
                else {
                    try{
                        //update contacto set nom = nombre, num_telef = telefono, fecha_nac = fecha where num_telef = telef;
                        String sql = "UPDATE "+Utilidades.Tabla_preferencia+" SET "+Utilidades.Campo_telef+" = '"+texto_num.getText()+"' WHERE "+Utilidades.Campo_telef+" = '"+numero+"'";
                        db.execSQL(sql);
                        sql = "UPDATE "+ Utilidades.Tabla_Contacto+" set "+Utilidades.Campo_telef+" = '"+texto_num.getText()+"', "
                                +Utilidades.Campo_nom+" = '"+texto_nombre.getText()+"', "+Utilidades.Campo_fecha_nac+" = '"+texto_fecha.getText()+"' WHERE "+Utilidades.Campo_telef +" = '"+numero+"'";
                        db.execSQL(sql);
                        Toast.makeText(getApplicationContext(),"SU CONTACTO FUE MODIFICADO CON ÉXITO",Toast.LENGTH_LONG).show();
                        db.close();
                        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = datos.edit();
                        editor.putString("numero_telefonito",texto_num.getText().toString());
                        editor.apply();
                        finish();
                    }

                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"YA EXISTE UN CONTACTO CON ESTE NUMERO DE TELEFONO",Toast.LENGTH_LONG).show();
                        db.close();
                    }
                }



            }
        });

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0: return new DatePickerDialog(this,selectorfecha, año,mes,dia);

        }
        return null;
    }
    public void mostrarCalendario(View v){
        showDialog(Tipo_dialogo);
    }
    public void mostrarFecha(){
        texto_fecha.setText(dia+"/"+(mes+1)+"/"+año);
    }


}
