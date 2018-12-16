package com.example.alejandro.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class listadoCiclos extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView tvInfoCiclo;
    // TODO: Rename and change types of parameters
    private int mParam1;
    private ArrayList<CicleFlorida> mParam2;

    private OnFragmentInteractionListener mListener;

    public listadoCiclos() {
        // Required empty public constructor
    }


    public static listadoCiclos newInstance(int param1, ArrayList<CicleFlorida> param2) {
        listadoCiclos fragment = new listadoCiclos();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putParcelableArrayList(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getParcelableArrayList(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado_ciclos, container, false);

        recorremosArray();

        return v;
    }
 public void recorremosArray(){


     if (mParam2!=null)
     {
         for(int i=0;i<mParam2.size();i++) {
             if (mParam1 ==1 && mParam2.get(i).getTipus()=="Mitjà")
             {
                 tvInfoCiclo.setText(tvInfoCiclo.getText()+mParam2.get(i).toString()+"\n"+"\n");
             }
             else if(mParam1==2 && mParam2.get(i).getTipus()=="Superior")
             {
                 tvInfoCiclo.setText(tvInfoCiclo.getText()+mParam2.get(i).toString()+"\n"+"\n");
             }
         }
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
