package chamorro.trabajo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Calendar;

import chamorro.trabajo.Utilidades.Utilidades;


public class AgregarContacto extends AppCompatActivity {
    private int año;
    private int mes;
    private int dia;
    private static DatePickerDialog.OnDateSetListener selectorfecha;
    private static final int Tipo_dialogo = 0;
    Button boton_agregar;
    Toolbar barra;
    EditText texto_nombre,texto_num,texto_fecha;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_contacto2);
        barra = (Toolbar) findViewById(R.id.barra_agregarcontacto);
        setSupportActionBar(barra);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        boton_agregar = (Button) findViewById(R.id.BTN_AGREGAR);
        texto_nombre = (EditText) findViewById(R.id.TXT_NOMBRE_C);
        texto_num = (EditText) findViewById(R.id.TXT_NUM_TELEF);
        texto_fecha = (EditText) findViewById(R.id.TXT_FECHA_C);
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


        barra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final BDHelper mDbHelper = new BDHelper(this,"bd_vinculator",null,1);

        boton_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                if ((texto_nombre.getText().toString().isEmpty()) || (texto_num.getText().toString().isEmpty()) || (texto_fecha.getText().toString().isEmpty())){
                    Toast.makeText(getApplicationContext(),"TODOS LOS CAMPOS SON OBLIGATORIOS, VUELVA A INTENTARLO.",Toast.LENGTH_LONG).show();
                }
                else if(año > 1900){
                    try{
                        //insert into contacto (telef_num,nombre_c,fecha_nac) values();
                        String sql = "INSERT INTO "+ Utilidades.Tabla_Contacto+" ("+Utilidades.Campo_telef+","+Utilidades.Campo_nom+","+Utilidades.Campo_fecha_nac+") VALUES('"+texto_num.getText().toString()+"','"+texto_nombre.getText().toString()+"','"+texto_fecha.getText().toString()+"')";
                        db.execSQL(sql);
                        Toast.makeText(getApplicationContext(),"SU CONTACTO FUE AGREGADO CORRECTAMENTE",Toast.LENGTH_LONG).show();
                        db.close();
                        texto_nombre.setText("");
                        texto_fecha.setText("");
                        texto_num.setText("");
                    }

                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"YA EXISTE UN CONTACTO CON ESTE NUMERO DE TELEFONO",Toast.LENGTH_LONG).show();
                        db.close();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"NO EXISTE ALGUIEN QUE PUEDA NACER EL AÑO"+ año,Toast.LENGTH_LONG).show();
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

