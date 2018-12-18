package com.example.alejandro.myapplication;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements fTitulaciones.fComunicaTitulaciones , fCiclos.fComunicaCiclos, listadoCiclos.OnFragmentInteractionListener{

    FragmentManager fm;
    FragmentTransaction ft;
    fTitulaciones fragment1;
    Fragment fragment2;
    Fragment fragment3;

    ArrayList<CicleFlorida> arrayCiclosFlorida;


    int btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayCiclosFlorida = new ArrayList<CicleFlorida>();

        creaDades(); //Omplim l'arrayCiclosFlorida

        btn1 = 1;
        btn2 = 2;
        fm = getSupportFragmentManager();

        fragment1 = (fTitulaciones) fm.findFragmentById(R.id.fTitulaciones);

        ft= fm.beginTransaction();

        ft.replace(R.id.fTitulaciones,fragment1);

        ft.commit();



}

    public void creaDades(){
        CicleFlorida c;

        c = new CicleFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        arrayCiclosFlorida.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        arrayCiclosFlorida.add(c);
    }

    @Override
    public void filtraPerGrau(ArrayList<CicleFlorida> elsCicles, String grauAFiltrar) {
        ArrayList <CicleFlorida> arrayFitltratPerTitulacioiGrau =new ArrayList<CicleFlorida>();

        for (CicleFlorida aux: elsCicles) {
            if (aux.getTipus() == grauAFiltrar) {
                arrayFitltratPerTitulacioiGrau.add(aux);
            }

        }


        ft= fm.beginTransaction();

        fragment3= listadoCiclos.newInstance(arrayFitltratPerTitulacioiGrau);
        ft.replace(R.id.listadoCiclos,fragment3);

        ft.commit();
    }

    @Override
    public void getIdBotonTitulaciones(int id) {
        ArrayList<CicleFlorida> arrayFitltratPerTitulacio =new ArrayList<CicleFlorida>();
        int numBotonsAMostrarEnFragment2;

        // Filtrem tots el ciclesde Florida per a buscar només els d'una titulacio (id)
        arrayFitltratPerTitulacio=recorrerArray(id);
        //Del llistat de cicles d'una titulacio, averigüem si hi ha mitja o superior
        numBotonsAMostrarEnFragment2 = hayCicloMedioOSuperior(arrayFitltratPerTitulacio);

        ft= fm.beginTransaction();

        fragment2 = fCiclos.newInstance(arrayFitltratPerTitulacio,numBotonsAMostrarEnFragment2);
        ft.replace(R.id.fCiclos,fragment2);

        ft.commit();
        btn1 = 0;
        btn2 = 0;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    public int hayCicloMedioOSuperior(ArrayList<CicleFlorida> arrayOnBuscare){
        boolean botoMitja=false, botoSuperior=false;

        for (CicleFlorida aux: arrayOnBuscare)
        {
                if (aux.getTipus()=="Mitjà")
                {

                    botoMitja = true;
                }
                if (aux.getTipus()=="Superior")
                {

                    botoSuperior = true;
                }
        }

        if(botoMitja&&botoSuperior) return 3;
        if(botoMitja&&!botoSuperior) return 1;
        if(!botoMitja&&botoSuperior) return 2;
        return 0;


    }
    public ArrayList<CicleFlorida> buscaInfo(String titulacio){
        boolean botoMitja=false, botoSuperior=false;
        ArrayList <CicleFlorida> arrayFitltratPerTitulacio =new ArrayList<CicleFlorida>();

        for (CicleFlorida aux: arrayCiclosFlorida)
        {
            if (aux.getFamiliaProfessional() == titulacio)
            {

                if (aux.getTipus()=="Mitjà")
                {

                    botoMitja = true;
                }
                if (aux.getTipus()=="Superior")
                {

                    botoSuperior = true;
                }
                arrayFitltratPerTitulacio.add(aux);
            }
        }
        return arrayFitltratPerTitulacio;
    }

    public  ArrayList <CicleFlorida> recorrerArray(int id)
    {
        ArrayList <CicleFlorida> newArray;
        newArray = new ArrayList<CicleFlorida>();
        switch (id){
            case 1:
                newArray= buscaInfo("EMPRESA");
                break;

            case 2:
                newArray=buscaInfo("ESPORT");
                break;
            case 3:
                newArray= buscaInfo("INFORMÀTICA");
                break;
        }

        return newArray;
    }


}
