package chamorro.trabajo.Adaptadores;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import chamorro.trabajo.Entidades.Contacto;
import chamorro.trabajo.R;

public class Adaptador_Contactos extends RecyclerView.Adapter<Adaptador_Contactos.ViewHolderContactos> implements View.OnClickListener {
    ArrayList<Contacto> list_contactos;
    private View.OnClickListener listener;

    public Adaptador_Contactos(ArrayList<Contacto> list_contactos) {
        this.list_contactos = list_contactos;

    }

    @Override
    public ViewHolderContactos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_contacto,null,false);
        view.setOnClickListener(this);
        return new ViewHolderContactos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderContactos holder, int position) {
        holder.nom_con.setText(list_contactos.get(position).getNom());
        holder.num.setText(list_contactos.get(position).getNum_telef());
    }

    @Override
    public int getItemCount() {
        return list_contactos.size();
    }
    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
            if (listener != null){
                listener.onClick(view);
            }
    }


    public class ViewHolderContactos extends RecyclerView.ViewHolder {
        TextView nom_con,num;

        public ViewHolderContactos(View itemView) {
            super(itemView);
            nom_con = (TextView) itemView.findViewById(R.id.id_contacto);
            num = (TextView) itemView.findViewById(R.id.id_numero);

        }



    }
}
