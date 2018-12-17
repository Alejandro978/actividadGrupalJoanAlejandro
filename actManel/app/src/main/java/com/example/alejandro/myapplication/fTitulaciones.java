package com.example.alejandro.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fTitulaciones extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnEmpresa;
    private Button btnDeportes;
    private Button btnInformatica;

    private fComunicaTitulaciones mListener;

    public fTitulaciones() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fTitulaciones newInstance(String param1, String param2) {
        fTitulaciones fragment = new fTitulaciones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_f_titulaciones, container, false);
        btnEmpresa =  (Button) v.findViewById(R.id.btnEmpresa);
        btnEmpresa.setOnClickListener(this);

        btnDeportes=  (Button) v.findViewById(R.id.btnDeportes);
        btnDeportes.setOnClickListener(this);

        btnInformatica=  (Button) v.findViewById(R.id.btnInformatica);
        btnInformatica.setOnClickListener(this);


        return v;
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==btnEmpresa.getId())
        {
            mListener.getIdBotonTitulaciones(1);

        }
        else if (v.getId()==btnDeportes.getId())
        {
            mListener.getIdBotonTitulaciones(2);
        }
        else if (v.getId()==btnInformatica.getId())
        {
            mListener.getIdBotonTitulaciones(3);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fComunicaTitulaciones) {
            mListener = (fComunicaTitulaciones) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement fComunicaTitulaciones");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    public interface fComunicaTitulaciones {
        // TODO: Update argument type and name
        void getIdBotonTitulaciones(int id);
    }
}
