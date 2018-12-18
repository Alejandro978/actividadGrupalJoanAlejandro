package com.example.alejandro.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class fCiclos extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "llistat de Cicles";
    private static final String ARG_PARAM2 = "num botons a mostrat";

    private ArrayList<CicleFlorida> llistatCicles1;
    private int botonsDeGrau;
    private Button btnMedio;
    private Button btnSuperior;


    //private String mParam2;
    //private String mParam1;

    private fComunicaCiclos mListener;

    public fCiclos() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fCiclos newInstance(ArrayList<CicleFlorida> llistatCicles, int numBotons) {
        fCiclos fragment = new fCiclos();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, llistatCicles);
        args.putInt(ARG_PARAM2, numBotons);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            llistatCicles1 = getArguments().getParcelableArrayList(ARG_PARAM1);
            botonsDeGrau = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_f_ciclos, container, false);

        btnMedio = (Button) v.findViewById(R.id.btnMedio);


        btnSuperior = (Button) v.findViewById(R.id.btnSuperior);


        if (botonsDeGrau == 1) {
            btnMedio.setEnabled(true);
            btnSuperior.setEnabled(false);
        }

        if (botonsDeGrau == 2) {
            btnSuperior.setEnabled(true);
            btnMedio.setEnabled(false);
        }
        if (botonsDeGrau == 3) {
            btnSuperior.setEnabled(true);
            btnMedio.setEnabled(true);
        }

        btnMedio.setOnClickListener(this);
        btnSuperior.setOnClickListener(this);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fComunicaCiclos) {
            mListener = (fComunicaCiclos) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement fComunicaCiclos");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btnMedio.getId()) {
            mListener.filtraPerGrau(llistatCicles1,"Mitjà");
        }
        else if (v.getId() == btnSuperior.getId()){
            mListener.filtraPerGrau(llistatCicles1,"Superior");
        }
    }


    public interface fComunicaCiclos {
        // TODO: Update argument type and name
        void filtraPerGrau(ArrayList<CicleFlorida> arrayCicles, String grau);
    }
}
