package com.example.alejandro.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fCiclos extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int parametro1;
    private int parametro2;
    private Button btnMedio;
    private Button btnSuperior;


    //private String mParam2;
    //private String mParam1;

    private fComunicaCiclos mListener;

    public fCiclos() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fCiclos newInstance(int param1, int param2) {
        fCiclos fragment = new fCiclos();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            parametro1 = getArguments().getInt(ARG_PARAM1);
            parametro2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_f_ciclos, container, false);

        btnMedio = (Button) v.findViewById(R.id.btnMedio);
        btnMedio.setOnClickListener(this);

        btnSuperior = (Button) v.findViewById(R.id.btnSuperior);
        btnSuperior.setOnClickListener(this);

        if (parametro1 == 1) {
            btnMedio.setEnabled(true);
        } else {
            btnMedio.setEnabled(false);
        }

        if (parametro2 == 2) {
            btnSuperior.setEnabled(true);
        } else {
            btnSuperior.setEnabled(false);
        }

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
            mListener.getIdBotonCiclos(1);
        }
        else if (v.getId() == btnSuperior.getId()){
            mListener.getIdBotonCiclos(2);
        }
    }


    public interface fComunicaCiclos {
        // TODO: Update argument type and name
        void getIdBotonCiclos(int id);
    }
}
