package com.example.progetto_oop.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progetto_oop.R;
import com.example.progetto_oop.modelli.Cocktail;
import com.example.progetto_oop.modelli.Menu;


public class GestoreListaElementi extends RecyclerView.Adapter<GestoreListaElementi.GestoreElemento> {

    private Activity parent;
    private String filtro_ricerca;
    private boolean Alcolici = false;
    private boolean Analcolici = false;
    private boolean Preferiti = false;
    private boolean ordina_Alcolici = false;
    private boolean ordina_Analcolici = false;
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
        this.ordina_Alcolici = ordina_Alcolico;
    }

    public void setOrdina_Analcolico(boolean ordina_Analcolico) {
        this.ordina_Analcolici = ordina_Analcolico;
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

            if ((Alcolici || ordina_Analcolici) && position >= 0 && position <= Menu.getNumeroCocktail()) {

                Cocktail element = Menu.getCocktail(position + 1);
                buildItem(holder, element);

            }

            if ((Analcolici || ordina_Analcolici) && position >= 0 && position <= Menu.getNumeroCocktail()) {

                position = 15 + position;
                Cocktail elemento = Menu.getCocktail(position + 1);
                buildItem(holder, elemento);


            }
        }
        if ((Preferiti || ordina_Preferiti) && position >= 0 && position <= Menu.getNumeroCocktail()) {

            Cocktail elemento = Menu.getCocktailById(db.getCocktailSalvati()[position]);
            buildItem(holder, elemento);

        }


        if (!Alcolici && !Analcolici && !Preferiti && !ordina_Preferiti && position >= 0 && position <= Menu.getNumeroCocktail()) {
            position++;
            Cocktail elemento = Menu.getCocktail(position);
            buildItem(holder, elemento);
        } else {
            //System.out.println("ordina_primi= "+ ordina_primo);
            if (ordina_Analcolici) {
                int count = 0;
                for (Cocktail e : Menu.getListaAlcolici()) {
                    String nome = parent.getString(Menu.getCocktailName(e.id)).toLowerCase();

                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Cocktail el = Menu.getCocktail(e.id);
                            buildItem(holder, el);
                        }

                        count++;
                    }
                }
            }
            if (ordina_Analcolici) {
                int count = 0;
                for (Cocktail e : Menu.getListaAnalcolici()) {

                    String nome = parent.getString(Menu.getCocktailName(e.id)).toLowerCase();
                    //System.out.println("posizione elemento:"+(e.id)+"  elemento="+nome);
                    //System.out.println("Il filtro contiene:"+ filtro_ricerca);
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Cocktail el = Menu.getCocktail(e.id);
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            }

            if (ordina_Preferiti) {
                int count = 0;
                for (int i = 0; i < db.getNumeroCocktailSalvati(); i++) {
                    String nome = parent.getString(Menu.getCocktailName(db.getCocktailSalvati()[i])).toLowerCase();
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position) {
                            Cocktail el = Menu.getCocktailById(db.getCocktailSalvati()[i]);
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }

            }

            if (!ordina_Analcolici && !ordina_Analcolici && !ordina_Preferiti) {
                int count = 0;
                for (Cocktail e : Menu.getCocktail()) {
                    String nome = parent.getString(Menu.getCocktailName(e.id)).toLowerCase();
                    if (nome.contains(this.filtro_ricerca)) {
                        if (count == position)
                            buildItem(holder, e);
                        count++;
                    }
                }
            }
        }
    }

    private void buildItem(@NonNull GestoreElemento holder, Cocktail elemento) {

        System.out.println("HO L'ELEMENTO:" + elemento.nome);

        holder.nome_elemento.setText(Menu.getCocktailName(elemento.id));
        if (elemento != null) {


            holder.img_elemento.setImageResource(Menu.getImageCocktail(elemento));
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
            if (Alcolici || ordina_Alcolici) {
                return 15;
            }
            if (Analcolici || ordina_Analcolici) {
                return 10;
            }
            if (Preferiti || ordina_Preferiti) {
                return db.getNumeroCocktailSalvati();
            }

            return Menu.getNumeroCocktail();
        }
        //se stiamo cercando una ricetta cocktail


        if (Alcolici) {
            ordina_Alcolici = true;
            ordina_Analcolici = false;
            ordina_Preferiti = false;
        }

        if (Analcolici) {
            ordina_Alcolici = false;
            ordina_Analcolici = true;
            ordina_Preferiti = false;
        }
        if (Preferiti) {
            ordina_Alcolici = false;
            ordina_Analcolici = false;
            ordina_Preferiti = true;

        }


        if (ordina_Alcolici) {
            int count = 0;
            for (Cocktail e : Menu.getListaAlcolici()) {
                String nome = parent.getString(Menu.getCocktailName(e.id)).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {

                    count++;
                }
            }

            return count;
        }
        if (ordina_Analcolici) {
            int count = 0;
            for (Cocktail e : Menu.getListaAnalcolici()) {
                String nome = parent.getString(Menu.getCocktailName(e.id)).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {
                    count++;
                }
            }
            return count;
        }
        if (ordina_Preferiti) {
            int count = 0;
            for (int i = 0; i < db.getNumeroCocktailSalvati(); i++) {
                String nome = parent.getString(Menu.getCocktailName(db.getCocktailSalvati()[i])).toLowerCase();
                if (nome.contains(this.filtro_ricerca)) {
                    count++;
                }
            }
            return count;
        }

        int count = 0;
        for (Cocktail e : Menu.getCocktail()) {
            String nome = parent.getString(Menu.getCocktailName(e.id)).toLowerCase();
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

            nome_elemento = view.findViewById(R.id.nome_Cocktail);
            riga_elemento = view.findViewById(R.id.riga_Cocktail);
            img_elemento = view.findViewById(R.id.immagine_Cocktail);



            /*blocco = view.findViewById(R.id.blocco_colore);
            numero_atomico = view.findViewById(R.id.numero_atomico);
            simbolo = view.findViewById(R.id.simbolo);
            */
        }
    }

}