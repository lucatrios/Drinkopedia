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
    private Button ordina_blocco;
    private Button ordina_numero;
    private Button preferiti;
    private TextInputEditText input_cerca;
    private FragmentActivity view;
    private GestoreListaElementi gestoreLista;
    private boolean reverse_simbolo = false;
    private boolean reverse_blocco = false;
    private boolean reverse_numero = false;
    private boolean primi=false;
    private boolean secondi=false;
    private boolean dolci=false;
    private boolean salvati=false;
    private boolean ordina_primo=false;
    private boolean ordina_secondi=false;
    private boolean ordina_dolci=false;

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
        ordina_blocco = view.findViewById(R.id.ordina_blocco);
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



                if(primi){
                    gestoreLista.setOrdina_primo(true); // se sono nel bottone dei primi setta la variabile che dice di ordinare i primi
                }
                else{
                    gestoreLista.setOrdina_primo(false);//se sono in un altro bottone non ordinare i primi
                }

                if(secondi){
                    gestoreLista.setOrdina_secondi(true);// se sono nel bottone dei primi setta la variabile che dice di ordinare i secondi
                }
                else{
                    gestoreLista.setOrdina_secondi(false);//se sono in un altro bottone non ordinare i secondi
                }

                if(dolci){
                    gestoreLista.setOrdina_dolci(true);// se sono nel bottone dei primi setta la variabile che dice di ordinare i dolci
                }
                else{
                    gestoreLista.setOrdina_dolci(false);//se sono in un altro bottone non ordinare i dolci
                }
                if(salvati){
                    gestoreLista.setOrdina_preferiti(true);
                }
                else{
                    gestoreLista.setOrdina_preferiti(false);
                }


                lista_elementi.setAdapter(gestoreLista);
                gestoreLista.setDb(db);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

        });

        /*
        Bottone per visualizzare i primi che si occupa anche di cambiare i testi dinamicamente di se
        e degli altri bottoni
         */

        ordina_numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestoreLista = new GestoreListaElementi(activity, input_cerca.getText().toString());

                gestoreLista.setPrimi(!primi);

                lista_elementi.setAdapter(gestoreLista);





                if(primi)
                    ordina_numero.setText("Primi");
                else {
                    preferiti.setText("Preferiti");
                    ordina_numero.setText("Menu");
                    ordina_simbolo.setText("secondi");
                    ordina_blocco.setText("dolci ");
                    secondi=false;
                    dolci=false;
                    salvati=false;

                }
                primi=!primi;
            }
        });
        /*
        Bottone per visualizzare i secondi che si occupa anche di cambiare i testi dinamicamente di se
        e degli altri bottoni
         */
        ordina_simbolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestoreLista = new GestoreListaElementi(activity, input_cerca.getText().toString());
                gestoreLista.setSecondi(!secondi);

                lista_elementi.setAdapter(gestoreLista);


                if(secondi)
                    ordina_simbolo.setText("secondi");
                else {
                    preferiti.setText("Preferiti");
                    ordina_simbolo.setText("menu");
                    ordina_blocco.setText("dolci");
                    ordina_numero.setText("primi");
                    primi=false;
                    dolci=false;
                    salvati=false;
                }
                secondi=!secondi;
            }
        });
        /*
        Bottone per visualizzare i dolci che si occupa anche di cambiare i testi dinamicamente di se
        e degli altri bottoni
         */
        ordina_blocco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gestoreLista = new GestoreListaElementi(activity, input_cerca.getText().toString());
                lista_elementi.setAdapter(gestoreLista);
                gestoreLista.setDolci(!dolci);


                if(dolci)
                    ordina_blocco.setText("dolci ");
                else {
                    preferiti.setText("Preferiti");
                    ordina_blocco.setText("menu");
                    ordina_simbolo.setText("secondi");
                    ordina_numero.setText("primi");
                    primi=false;
                    secondi=false;
                    salvati=false;
                }
                dolci=!dolci;
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
                    ordina_blocco.setText("dolci");
                    ordina_simbolo.setText("secondi");
                    ordina_numero.setText("primi");
                    primi=false;
                    secondi=false;
                    dolci=false;
                }
                salvati = !salvati;


            }


        });



        gestoreLista = new GestoreListaElementi(activity, "");
        lista_elementi.setAdapter(gestoreLista);

        return view;


    }

}