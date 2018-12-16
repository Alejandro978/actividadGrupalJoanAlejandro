package com.example.alejandro.myapplication;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements fTitulaciones.fComunicaTitulaciones , fCiclos.fComunicaCiclos, listadoCiclos.OnFragmentInteractionListener{

    FragmentManager fm;
    FragmentTransaction ft;
    fTitulaciones fragment1;
    Fragment fragment2;
    Fragment fragment3;

    ArrayList<CicleFlorida> arrayCiclosFlorida;
    ArrayList <CicleFlorida> newArray;

    int btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayCiclosFlorida = new ArrayList<CicleFlorida>();
        btn1 = 1;
        btn2 = 2;
        fm = getSupportFragmentManager();
        fragment2 = fCiclos.newInstance(btn1,btn2);
        fragment3= listadoCiclos.newInstance(0,null);
        fragment1 = (fTitulaciones) fm.findFragmentById(R.id.fTitulaciones);

        ft= fm.beginTransaction();

        ft.replace(R.id.fCiclos,fragment2);
        ft.replace(R.id.listadoCiclos,fragment3);

        ft.commit();

        creaDades();

}

    @Override
    public void getIdBotonCiclos(int id) {
        ft= fm.beginTransaction();

        fragment3= listadoCiclos.newInstance(id,newArray);
        ft.replace(R.id.listadoCiclos,fragment3);

        ft.commit();
    }

    @Override
    public void getIdBotonTitulaciones(int id) {
        recorrerArray(id);
        ft= fm.beginTransaction();

        fragment2 = fCiclos.newInstance(btn1,btn2);
        ft.replace(R.id.fCiclos,fragment2);

        ft.commit();
        btn1 = 1;
        btn2 = 2;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void recorrerArray(int id)
    {

        newArray = new ArrayList<CicleFlorida>();
        switch (id){
            case 1:
                for (CicleFlorida aux: newArray)
                {
                    if (aux.getFamiliaProfessional() == "EMPRESA")
                    {

                        if (aux.getTipus()=="Mitjà")
                        {

                            btn1 = 1;
                        }
                        if (aux.getTipus()=="Superior")
                        {

                            btn2 = 1;
                        }
                        newArray.add(aux);
                    }
                }
                break;

            case 2:
                for (CicleFlorida aux: newArray)
                {
                    if (aux.getFamiliaProfessional() == "ESPORT")
                    {
                        if (aux.getTipus()=="Mitjà")
                        {
                            btn1 = 1;
                        }
                        if (aux.getTipus()=="Superior")
                        {
                            btn2 = 2;
                        }
                        newArray.add(aux);
                    }
                }
                break;
            case 3:
                for (CicleFlorida aux: newArray)
                {
                    if (aux.getFamiliaProfessional() == "INFORMÀTICA")
                    {
                        if (aux.getTipus()=="Mitjà")
                        {
                            btn1 = 1;
                        }
                        if (aux.getTipus()=="Superior")
                        {
                            btn2 = 2;
                        }
                        newArray.add(aux);
                    }
                }
                break;
        }
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
}
