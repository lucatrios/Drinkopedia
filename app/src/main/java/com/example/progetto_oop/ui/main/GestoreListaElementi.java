package com.example.progetto_oop.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.content.Context;



import com.example.progetto_oop.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progetto_oop.modelli.Menu;
import com.example.progetto_oop.modelli.Cocktail;


import com.example.progetto_oop.ui.ingredienti.;


public class GestoreListaElementi extends RecyclerView.Adapter<GestoreListaElementi.GestoreElemento> {

    private Activity parent;
    private String filtro_ricerca;
    private boolean Alcolici = false;
    private boolean Analcolici = false;
    private boolean Preferiti = false;
    private boolean ordina_Alcolico = false;
    private boolean ordina_Analcolico = false;
    private boolean ordina_Preferiti = false;
    private ImageButton salva;
    private ConnectionDB db;


    public void setDb(ConnectionDB db) {
        this.db = db;
    }

    public void setAlcolici(boolean Alcolici) {
        this.Alcolici = Alcolici;
    }

    public void setAnalcolici(boolean Analcolici) {
        this.Analcolici = Analcolici;
    }

    public void setPreferiti(boolean Preferiti) {
        this.Preferiti = Preferiti;
    }

    public void setOrdina_Alcolico(boolean ordina_Alcolico) {
        this.ordina_Alcolico = ordina_Alcolico;
    }

    public void setOrdina_Analcolico(boolean ordina_Analcolico) {
        this.ordina_Analcolico = ordina_Analcolico;
    }

    public void setOrdina_Preferiti(boolean ordina_Preferiti) {
        this.ordina_Preferiti = ordina_Preferiti;
    }

    public void setParent(Activity parent) {
        this.parent = parent;
    }


    public GestoreListaElementi(Activity parent, String filtro_ricerca) {
        this.parent = parent;
        if (filtro_ricerca != null)
            this.filtro_ricerca = filtro_ricerca.toLowerCase();

    }


    @NonNull
    @Override
    public GestoreElemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GestoreElemento(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_elemento, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GestoreElemento holder, int position) {
        Activity parent = this.parent;
        if (filtro_ricerca.isEmpty()) {

            if ((Alcolici || ordina_Alcolico) && position >= 0 && position <= Menu.getNumeroRicette()) {

                Ricetta element = Ricettario.getRicetta(position + 1);
                buildItem(holder, element);

            }

            if ((secondi || ordina_secondi) && position >= 0 && position <= Ricettario.getNumeroRicette()) {

                position = 15 + position;
                Ricetta elemento = Ricettario.getRicetta(position + 1);
                buildItem(holder, elemento);


            }
            if ((dolci || ordina_dolci) && position >= 0 && position <= Ricettario.getNumeroRicette()) {

                position = 25 + position;
                Ricetta elemento = Ricettario.getRicetta(position + 1);
                buildItem(holder, elemento);


            }
            if ((preferiti || ordina_preferiti) && position >= 0 && position <= Ricettario.getNumeroRicette()) {

                Ricetta elemento = Ricettario.getRicettaById(db.getRicetteSalvate()[position]);
                buildItem(holder, elemento);

            }


            if (!primi && !secondi && !dolci && !preferiti && !ordina_preferiti && position >= 0 && position <= Ricettario.getNumeroRicette()) {
                position++;
                Ricetta elemento = Ricettario.getRicetta(position);
                buildItem(holder, elemento);
            }
        } else {
            //System.out.println("ordina_primi= "+ ordina_primo);
            if (ordina_primo) {
                int count = 0;
                for (Ricetta e : Ricettario.getListaPrimi()) {
                    String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();

                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Ricetta el = Ricettario.getRicetta(e.id);
                            buildItem(holder, el);
                        }

                        count++;
                    }
                }
            }
            //System.out.println("ordina_secondi= "+ordina_secondi);
            if (ordina_secondi) {
                int count = 0;
                for (Ricetta e : Ricettario.getListaSecondi()) {

                    String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
                    //System.out.println("posizione elemento:"+(e.id)+"  elemento="+nome);
                    //System.out.println("Il filtro contiene:"+ filtro_ricerca);
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Ricetta el = Ricettario.getRicetta(e.id);
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            }
            //System.out.println("ordina_dolci= "+ordina_dolci);
            if (ordina_dolci) {
                int count = 0;
                for (Ricetta e : Ricettario.getListaDolci()) {
                    String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Ricetta el = Ricettario.getRicetta(e.id);
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            }

            if (ordina_preferiti) {
                int count = 0;
                for (int i = 0; i < db.getNumeroElementiSalvati(); i++) {
                    String nome = parent.getString(Ricettario.getRicettaName(db.getRicetteSalvate()[i])).toLowerCase();
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Ricetta el = Ricettario.getRicettaById(db.getRicetteSalvate()[i]);
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }

            }

            if (!ordina_primo && !ordina_secondi && !ordina_dolci && !ordina_preferiti) {
                int count = 0;
                for (Ricetta e : Ricettario.getRicette()) {
                    String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position)
                            buildItem(holder, e);
                        count++;
                    }
                }
            }
        }
    }

    private void buildItem(@NonNull GestoreElemento holder, Ricetta elemento) {

        System.out.println("HO L'ELEMENTO:" + elemento.nome);

        holder.nome_elemento.setText(Ricettario.getRicettaName(elemento.id));
        if (elemento != null) {


            holder.img_elemento.setImageResource(Ricettario.getImagePlate(elemento));
            holder.riga_elemento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(parent, ElmentoActivity.class);

                    intent.putExtra("numero", elemento.id);
                    intent.putExtra("salvato", elemento.salvata);
                    intent.putExtra("Tipologia", elemento.category);
                    parent.startActivity(intent);
                }
            });
        }
    }


    @Override
    public int getItemCount() {


        if (this.filtro_ricerca.isEmpty()) {
            if (primi || ordina_primo) {
                return 15;
            }
            if (secondi || ordina_secondi) {
                return 10;
            }
            if (dolci || ordina_dolci) {
                return 15;
            }
            if (preferiti || ordina_preferiti) {
                return db.getNumeroElementiSalvati();
            }

            return Ricettario.getNumeroRicette();
        }
        //se stiamo cercando una ricetta


        if (primi) {
            ordina_primo = true;
            ordina_secondi = false;
            ordina_dolci = false;
            ordina_preferiti = false;
        }

        if (secondi) {
            ordina_primo = false;
            ordina_secondi = true;
            ordina_dolci = false;
            ordina_preferiti = false;
        }
        if (dolci) {
            ordina_primo = false;
            ordina_secondi = false;
            ordina_dolci = true;
            ordina_preferiti = false;

        }
        if (preferiti) {
            ordina_primo = false;
            ordina_secondi = false;
            ordina_dolci = false;
            ordina_preferiti = true;

        }


        if (ordina_primo) {
            int count = 0;
            for (Ricetta e : Ricettario.getListaPrimi()) {
                String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {

                    count++;
                }
            }

            return count;
        }
        if (ordina_secondi) {
            int count = 0;
            for (Ricetta e : Ricettario.getListaSecondi()) {
                String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {
                    count++;
                }
            }
            return count;
        }
        if (ordina_dolci) {
            int count = 0;
            for (Ricetta e : Ricettario.getListaDolci()) {
                String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {
                    count++;
                }
            }
            return count;
        }

        if (ordina_preferiti) {
            int count = 0;
            for (int i = 0; i < db.getNumeroElementiSalvati(); i++) {
                String nome = parent.getString(Ricettario.getRicettaName(db.getRicetteSalvate()[i])).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {
                    count++;
                }
            }
            return count;
        }

        int count = 0;
        for (Ricetta e : Ricettario.getRicette()) {
            String nome = parent.getString(Ricettario.getRicettaName(e.id)).toLowerCase();
            if (nome.contains(this.filtro_ricerca)) {
                count++;
            }
        }


        return count;
    }

    public class GestoreElemento extends RecyclerView.ViewHolder {

        private LinearLayout riga_elemento;
        private TextView nome_elemento;
        private ImageView img_elemento;

        public GestoreElemento(@NonNull View view) {
            super(view);

            nome_elemento = view.findViewById(R.id.nome_ricetta);
            riga_elemento = view.findViewById(R.id.riga_elemento);
            img_elemento = view.findViewById(R.id.immagine_piatto);



            /*blocco = view.findViewById(R.id.blocco_colore);
            numero_atomico = view.findViewById(R.id.numero_atomico);
            simbolo = view.findViewById(R.id.simbolo);
            */
        }
    }

}