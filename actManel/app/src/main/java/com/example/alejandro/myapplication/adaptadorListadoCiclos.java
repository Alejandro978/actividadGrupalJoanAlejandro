package com.example.alejandro.myapplication;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adaptadorListadoCiclos extends RecyclerView.Adapter<adaptadorListadoCiclos.elViewHolder> {

    //CREAMOS ARRAYLIST QUE NOS TRAEMOS DE CICLOS FLORIDA:
    ArrayList<CicleFlorida> listadoCiclos;

    public adaptadorListadoCiclos(ArrayList<CicleFlorida> lCiclos) {
        listadoCiclos = lCiclos;
    }

    public static class elViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre;
        TextView tvDescripcion;
        ImageView ivAdd;
        ImageView ivDel;

        public elViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAdd = (ImageView) itemView.findViewById(R.id.ivAdd);
            ivDel = (ImageView) itemView.findViewById(R.id.ivDel);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvDescripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
        }


    }

    @NonNull
    @Override
    public elViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listado_ciclos, viewGroup, false);
        return new elViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final elViewHolder elViewHolder, int i) {

        elViewHolder.tvNombre.setText(listadoCiclos.get(i).getTitol());
        elViewHolder.tvDescripcion.setText(this.listadoCiclos.get(i).getDescripcio());
        elViewHolder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int i = elViewHolder.getAdapterPosition();
                        listadoCiclos.remove(i);
                        notifyItemRemoved(i);
                    }
                });
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    }
                    });
                /*TODO:AFEGIR ELS CONTROLS DEPENENT DEL BOTÒ POLSAT*/

                AlertDialog dialog = builder.create();


                dialog.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return listadoCiclos.size();
    }

}
