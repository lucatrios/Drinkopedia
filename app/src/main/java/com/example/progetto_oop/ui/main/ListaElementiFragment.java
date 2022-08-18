package com.example.progetto_oop.ui.main;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.progetto_oop.R;
import com.example.progetto_oop.ui.MainActivity;
import com.google.android.material.textfield.TextInputEditText;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ListaElementiFragment extends Fragment {

    private RecyclerView lista_elementi;
    private Button ordina_simbolo;
    private Button ordina_numero;
    private Button preferiti;
    private TextInputEditText input_cerca;
    private FragmentActivity view;
    private GestoreListaElementi gestoreLista;
    private boolean reverse_simbolo = false;
    private boolean reverse_numero = false;
    private boolean Alcolici=false;
    private boolean Analcolici=false;
    private boolean salvati=false;
    private boolean ordina_Alcolici=false;
    private boolean ordina_Analcolici=false;

    private ConnectionDB db;


    public static ListaElementiFragment newInstance() {
        return new ListaElementiFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_elementi_fragment, container, false);

        lista_elementi = view.findViewById(R.id.lista_elementi);
        lista_elementi.setHasFixedSize(true);
        lista_elementi.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ordina_simbolo = view.findViewById(R.id.ordina_simbolo);
        ordina_numero = view.findViewById(R.id.ordina_numero);
        input_cerca = view.findViewById(R.id.input_cerca);
        preferiti=view.findViewById(R.id.Preferiti);
        db= new ConnectionDB(getContext());

        Activity activity = this.getActivity();

        input_cerca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            /*
            onTextChanged si occupa di risolvere il problema che non mi permetteva di ricercare solo nella categoria
            selezionata ma cercava in tutto il menu
             */
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                gestoreLista = new GestoreListaElementi(activity, s.toString());



                if(Alcolici){
                    gestoreLista.setOrdina_Alcolici(true); // se sono nel bottone degli alcolici setta la variabile che dice di ordinare gli alcolici
                }
                else{
                    gestoreLista.setOrdina_Alcolici(false);//se sono in un altro bottone non ordinare gli alcolici
                }

                if(Analcolici){
                    gestoreLista.setOrdina_Analcolici(true);// se sono nel bottone degli alcolici setta la variabile che dice di ordinare gli analcolici
                }
                else{
                    gestoreLista.setOrdina_Analcolici(false);//se sono in un altro bottone non ordinare gli analcolici
                }
                if(salvati){
                    gestoreLista.setOrdina_Preferiti(true);
                }
                else{
                    gestoreLista.setOrdina_Preferiti(false);
                }


                lista_elementi.setAdapter(gestoreLista);
                gestoreLista.setDb(db);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });

        /*
        Bottone per visualizzare gli alcolici che si occupa anche di cambiare i testi dinamicamente di se
        e degli altri bottoni
         */

        ordina_numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestoreLista = new GestoreListaElementi(activity, input_cerca.getText().toString());

                gestoreLista.setAlcolici(!Alcolici);

                lista_elementi.setAdapter(gestoreLista);

                if(Alcolici)
                    ordina_numero.setText("Alcolici");
                else {
                    preferiti.setText("Preferiti");
                    ordina_numero.setText("Menu");
                    ordina_simbolo.setText("Analcolici");
                    Analcolici=false;
                    salvati=false;

                }
                Alcolici=!Alcolici;
            }
        });
        /*
        Bottone per visualizzare gli analcolici che si occupa anche di cambiare i testi dinamicamente di se
        e degli altri bottoni
         */
        ordina_simbolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestoreLista = new GestoreListaElementi(activity, input_cerca.getText().toString());
                gestoreLista.setAnalcolici(!Analcolici);

                lista_elementi.setAdapter(gestoreLista);


                if(Analcolici)
                    ordina_simbolo.setText("Analcolici");
                else {
                    preferiti.setText("Preferiti");
                    ordina_simbolo.setText("Menu");
                    ordina_numero.setText("Alcolici");
                    Alcolici=false;
                    salvati=false;
                }
                Analcolici=!Analcolici;
            }
        });

        preferiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestoreLista = new GestoreListaElementi(activity, input_cerca.getText().toString());
                lista_elementi.setAdapter(gestoreLista);

                gestoreLista.setDb(db);
                gestoreLista.setPreferiti(!salvati);


                if (salvati)
                    preferiti.setText("Preferiti");
                else {
                    preferiti.setText("Menù");
                    ordina_simbolo.setText("Analcolici");
                    ordina_numero.setText("Alcolici");
                    Alcolici=false;
                    Analcolici=false;
                }
                salvati = !salvati;
            }

        });

        gestoreLista = new GestoreListaElementi(activity, "");
        lista_elementi.setAdapter(gestoreLista);

        return view;

    }
}