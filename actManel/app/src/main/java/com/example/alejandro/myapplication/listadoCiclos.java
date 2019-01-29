package com.example.alejandro.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class listadoCiclos extends Fragment {


    private static final String ARG_PARAM2 = "llistat cicles filtrat final";

    private TextView tvInfoCiclo;
    // TODO: Rename and change types of parameters
    private int mParam1;
    private ArrayList<CicleFlorida> mParam2;

    ArrayList<CicleFlorida> listadoCiclos;
    //CREAMOS LINEAR LAYOUT MANAGER PARA EL RECYCLER VIEW
    LinearLayoutManager llm;
    RecyclerView rv;

    adaptadorListadoCiclos alc;
    private OnFragmentInteractionListener mListener;

    public listadoCiclos() {
        // Required empty public constructor
    }


    public static listadoCiclos newInstance(ArrayList<CicleFlorida> param2) {
        listadoCiclos fragment = new listadoCiclos();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listadoCiclos = new ArrayList<CicleFlorida>();

        if (getArguments() != null) {

            mParam2 = getArguments().getParcelableArrayList(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado_ciclos, container, false);
        /*recorremosArray();*/
        //       tvInfoCiclo = v.findViewById(R.id.tvInfoCiclos);
        rv = v.findViewById(R.id.rvListado);
        llm = new LinearLayoutManager(v.getContext(),1,false);
        rv.setLayoutManager(llm);
        alc = new adaptadorListadoCiclos(mParam2);
        rv.setAdapter(alc);


        return v;
    }

   /* public void recorremosArray() {

        tvInfoCiclo.setText("");
        if (mParam2 != null) {
            for (int i = 0; i < mParam2.size(); i++) {

                tvInfoCiclo.setText(tvInfoCiclo.getText() + mParam2.get(i).toString() + "\n" + "\n");

            }
        }
    }*/


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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
