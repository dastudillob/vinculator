package chamorro.trabajo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import chamorro.trabajo.Adaptadores.Adaptador_Contactos;
import chamorro.trabajo.Entidades.Contacto;
import chamorro.trabajo.Utilidades.Utilidades;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
         ArrayList<Contacto> list_contactos;
        RecyclerView recycler_contacto;
        BDHelper conn;
        String numero_telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new BDHelper(this,"bd_vinculator",null,1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }



    @Override
    protected void onResume(){
        super.onResume();
        list_contactos = new ArrayList<>();
        recycler_contacto= (RecyclerView) findViewById(R.id.recycler_contactos);
        recycler_contacto.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Adaptador_Contactos adapter = new Adaptador_Contactos(list_contactos);
        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Pantalla_Contacto.class);
                numero_telefono = list_contactos.get(recycler_contacto.getChildAdapterPosition(v)).getNum_telef();
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = datos.edit();
                editor.putString("numero_telefonito",numero_telefono);
                editor.apply();
                startActivity(i);

            }
        });
        recycler_contacto.setAdapter(adapter);
        consultarContactos();

    }

    private void consultarContactos() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Contacto contacto = null;
        Cursor cursor = db.rawQuery("SELECT "+ Utilidades.Campo_nom+", "+Utilidades.Campo_telef+" FROM "+Utilidades.Tabla_Contacto,null);
        while(cursor.moveToNext()){
            contacto = new Contacto();
            contacto.setNom(cursor.getString(0));
            contacto.setNum_telef(cursor.getString(1));
            list_contactos.add(contacto);
        }
        db.close();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inicio) {
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
        } else if (id == R.id.se_parte) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void iragregar(View vista){
            Intent i = new Intent(this,AgregarContacto.class);
            startActivity(i);
        }

}
