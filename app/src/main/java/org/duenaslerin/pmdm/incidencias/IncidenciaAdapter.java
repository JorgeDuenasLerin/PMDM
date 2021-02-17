package org.duenaslerin.pmdm.incidencias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.duenaslerin.pmdm.R;

import java.util.ArrayList;
import java.util.List;

import arquitectura.AdaptadorPreguntas;

public class IncidenciaAdapter extends RecyclerView.Adapter<IncidenciaAdapter.ViewHolder> {

    private List<Incidencia> mData;
    private LayoutInflater mInflater;


    // data is passed into the constructor
    IncidenciaAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<Incidencia>();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvEstado;
        TextView tvLugar;
        TextView tvDescripcion;

        ViewHolder(View itemView) {
            super(itemView);
            tvEstado = itemView.findViewById(R.id.idEstado);
            tvLugar = itemView.findViewById(R.id.idLugar);
            tvDescripcion = itemView.findViewById(R.id.idDescripcion);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }



    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_listado_incidencias_linea, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(IncidenciaAdapter.ViewHolder holder, int position) {
        Incidencia info = mData.get(position);
        holder.tvEstado.setText(info.estado);
        holder.tvLugar.setText(info.lugar);
        holder.tvDescripcion.setText(info.descripcion);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(ArrayList<Incidencia> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }

    // convenience method for getting data at click position
    Incidencia getItem(int id) {
        return mData.get(id);
    }

    private IncidenciaAdapter.ItemClickListener mClickListener;

    // allows clicks events to be caught
    void setClickListener(IncidenciaAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}