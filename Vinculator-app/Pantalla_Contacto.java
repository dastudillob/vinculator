package chamorro.trabajo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import chamorro.trabajo.Entidades.Contacto;
import chamorro.trabajo.Utilidades.Utilidades;




public class Pantalla_Contacto extends AppCompatActivity {
    TextView nombre,numero,fecha;
    String numero1;
    BDHelper conn;
    String numero2;
    Toolbar barra;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_contacto);
        conn = new BDHelper(this,"bd_vinculator",null,1);
        barra = (Toolbar) findViewById(R.id.barra_pantalla_contacto);
        setSupportActionBar(barra);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        barra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void buscar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+ Utilidades.Campo_nom+", "+Utilidades.Campo_fecha_nac+" FROM "+Utilidades.Tabla_Contacto+" WHERE "+Utilidades.Campo_telef+" = '"+numero1+"'",null);
        cursor.moveToFirst();
        nombre.setText(cursor.getString(0));
        fecha.setText(cursor.getString(1));
        db.close();
    }
    public void iramodificar (View view){
        Intent i = new Intent(getApplicationContext(),Modificar_Contacto.class);
        Contacto contacto = new Contacto();
        contacto.setNum_telef(numero1);
        contacto.setNom(nombre.getText().toString());
        Bundle mibundle = new Bundle();
        mibundle.putSerializable("numero_telefonito",contacto);
        i.putExtras(mibundle);
        startActivity(i);
    }
    public void iraencuesta(View view){
        Intent i = new Intent(getApplicationContext(),Pantalla_Encuesta.class);
        Contacto contacto = new Contacto();
        contacto.setNum_telef(numero.getText().toString());
        contacto.setNom(nombre.getText().toString());
        Bundle mibundle = new Bundle();
        mibundle.putSerializable("contactito",contacto);
        i.putExtras(mibundle);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.opc_preferencia) {
            Intent i = new Intent(this,Pantalla_Preferencias.class);
            numero2 = (String) numero.getText();
            Bundle mibundle = new Bundle();
            mibundle.putString("numero_telefonito",numero2);
            i.putExtras(mibundle);
            startActivity(i);
            return true;
        }
        if (id == R.id.opc_eliminar_c) {
            eliminarContacto();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void eliminarContacto() {
        final SQLiteDatabase db = conn.getWritableDatabase();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Realmente deseas Eliminar este contacto? :(");
        builder.setTitle("ELIMINAR CONTACTO");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try{
                    //sql = "DELETE FROM preferencia WHERE num telef = numero"
                    String sql = "DELETE FROM "+Utilidades.Tabla_preferencia+" WHERE "+Utilidades.Campo_telef+" = '"+numero1+"'";
                    db.execSQL(sql);
                    //sql = "DELETE FROM contactos WHERE num_telef = numero"
                    sql = "DELETE FROM "+Utilidades.Tabla_Contacto+" WHERE "+Utilidades.Campo_telef+" = '"+numero1+"'";
                    db.execSQL(sql);
                    db.close();
                    finish();


                }catch (SQLException e){
                    db.close();
                }
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void onResume(){
        super.onResume();
        nombre = (TextView) findViewById(R.id.Txt_nombre_especifico);
        numero = (TextView) findViewById(R.id.txt_numero_especifico);
        fecha = (TextView) findViewById(R.id.txt_fecha_especifica);
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        numero1 = datos.getString("numero_telefonito","");
        numero.setText(numero1);
        buscar();
    }

}

