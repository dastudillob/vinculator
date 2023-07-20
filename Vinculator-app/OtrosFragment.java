package chamorro.trabajo;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import chamorro.trabajo.Adaptadores.Adaptador_Preferencias;
import chamorro.trabajo.Entidades.Contacto;
import chamorro.trabajo.Entidades.Preferencia;
import chamorro.trabajo.Utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Lista_PreferenciaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Lista_PreferenciaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtrosFragment extends Fragment {
    BDHelper conn;
    String numero;


    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerViewPref;
    ArrayList<Preferencia> lista_pref;

    public OtrosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conn = new BDHelper(getContext(),"bd_vinculator",null,1);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_lista__preferencia, container, false);
        lista_pref = new ArrayList<>();
        SharedPreferences dato = PreferenceManager.getDefaultSharedPreferences(getContext());
        numero = dato.getString("numerito","");
        recyclerViewPref = (RecyclerView) vista.findViewById(R.id.recycler_pref);
        recyclerViewPref.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        Adaptador_Preferencias adapter = new Adaptador_Preferencias(lista_pref);
        recyclerViewPref.setAdapter(adapter);
        return vista;
    }

    private void llenarLista() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Preferencia pref = null;
        Cursor cursor = db.rawQuery("SELECT gusto FROM preferencia WHERE num_telef = '"+numero+"' AND cod_cat = 'OT'" ,null);
        while(cursor.moveToNext()){
            pref = new Preferencia();
            pref.setGusto(cursor.getString(0));
            lista_pref.add(pref);
        }
        db.close();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public void onResume(){
        super.onResume();
        recyclerViewPref.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        Adaptador_Preferencias adapter = new Adaptador_Preferencias(lista_pref);
        recyclerViewPref.setAdapter(adapter);
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}