package chamorro.trabajo.Adaptadores;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


import chamorro.trabajo.Entidades.Preferencia;
import chamorro.trabajo.R;

public class Adaptador_Preferencias extends RecyclerView.Adapter<Adaptador_Preferencias.PreferenciaViewHolder> {

    ArrayList<Preferencia> list_pref;

    public Adaptador_Preferencias(ArrayList<Preferencia> list_pref) {
        this.list_pref = list_pref;

    }

    @Override
    public PreferenciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_pref,null,false);
        return new PreferenciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PreferenciaViewHolder holder, int position) {
        holder.preferencia.setText(list_pref.get(position).getGusto());

    }

    @Override
    public int getItemCount() {
        return list_pref.size();
    }


    public class PreferenciaViewHolder extends RecyclerView.ViewHolder {
        TextView preferencia;

        public PreferenciaViewHolder(View itemView) {
            super(itemView);
            preferencia = (TextView) itemView.findViewById(R.id.txt_pref);


        }



    }
}
