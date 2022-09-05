package com.example.progetto_OOP.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progetto_OOP.R;
import com.example.progetto_OOP.db.Cocktail;
import com.example.progetto_OOP.db.CocktailDao;
import com.example.progetto_OOP.utils.CocktailUtils;

import java.util.ArrayList;

/**
 * Class that extends RecyclerView.Adapter
 */
public final class CocktailListManager extends RecyclerView.Adapter<CocktailListManager.CocktailManager> {
    private final Activity parent;
    private final CocktailDao dao;
    private final String researchFilter;
    private boolean isShowAlcoholics;
    private boolean isShowAnalcoholics;
    private boolean isShowPreferred;

    /**
     * List manager to build the list of cocktail showed.
     * It manages the buttons (alcoholics, analcoholics, preferred) and for each category selected it shows the correct list of cocktails.
     * It manages the TextInputEditText researchInput in order to show the correct cocktails when it gets a researchFilter string.
     * @param parent: activity passed from the caller CocktailActivity.
     * @param researchFilter: string that represents.
     * @param dao: data access object to work with the BarDatabase.
     * @param alcoholics: button for alcoholic cocktails.
     * @param analcoholics: button for analcoholic cocktails
     * @param preferred: button for saved cocktails.
     */
    public CocktailListManager(Activity parent, String researchFilter, CocktailDao dao, Button alcoholics, Button analcoholics, Button preferred) {
        this.parent = parent;
        this.dao = dao;
        this.researchFilter = researchFilter;
        // Listener to set show/hide alcoholics/analcoholics
        this.isShowAlcoholics = alcoholics.getText().toString().equals("Menù");
        this.isShowAnalcoholics = analcoholics.getText().toString().equals("Menù");
        this.isShowPreferred = preferred.getText().toString().equals("Menù");
        alcoholics.setOnClickListener(view1 -> {
            if (alcoholics.getText().toString().equals("Menù")) {
                isShowAlcoholics = false;
                alcoholics.setText("Alcolici");
            } else {
                isShowAlcoholics = true;
                alcoholics.setText("Menù");
            }
            if (analcoholics.getText().toString().equals("Menù")) {
                isShowAnalcoholics = false;
                analcoholics.setText("Analcolici");
            }
            if (preferred.getText().toString().equals("Menù")) {
                isShowPreferred = false;
                preferred.setText("Preferiti");
            }
            notifyDataSetChanged();
        });
        analcoholics.setOnClickListener(view1 -> {

            if (analcoholics.getText().toString().equals("Menù")) {
                isShowAnalcoholics = false;
                analcoholics.setText("Analcolici");
            } else {
                isShowAnalcoholics = true;
                analcoholics.setText("Menù");
            }
            if (alcoholics.getText().toString().equals("Menù")) {
                isShowAlcoholics = false;
                alcoholics.setText("Alcolici");
            }
            if (preferred.getText().toString().equals("Menù")) {
                isShowPreferred = false;
                preferred.setText("Preferiti");
            }
            notifyDataSetChanged();
        });
        preferred.setOnClickListener(view1 -> {
            if (preferred.getText().toString().equals("Menù")) {
                isShowPreferred = false;
                preferred.setText("Preferiti");
            } else {
                isShowPreferred = true;
                preferred.setText("Menù");
            }
            if (alcoholics.getText().toString().equals("Menù")) {
                isShowAlcoholics = false;
                alcoholics.setText("Alcolici");
            }
            if (analcoholics.getText().toString().equals("Menù")) {
                isShowAnalcoholics = false;
                analcoholics.setText("Analcolici");
            }
            notifyDataSetChanged();
        });
    }

    @NonNull
    @Override
    public CocktailManager onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CocktailManager(LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktail_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull CocktailManager holder, int position) {
        /**
         * Two different options whether the research filter is empty or not
         */
        //empty research filter
        if (researchFilter.isEmpty()) {
            if (isShowAlcoholics && position >= 0 && position < dao.getAlcoholicCocktails().size()) {
                buildItem(holder, dao.getAlcoholicCocktails().get(position));
            } else if (isShowAnalcoholics && position >= 0 && position < dao.getAnalcoholicCocktails().size()) {
                buildItem(holder, dao.getAnalcoholicCocktails().get(position));
            } else if (isShowPreferred && position >= 0 && position < dao.getSavedCocktails().size()) {
                buildItem(holder, dao.getSavedCocktails().get(position));
            } else if (!isShowAlcoholics && !isShowAnalcoholics && !isShowPreferred && position >= 0 && position < dao.getCocktails().size()) {
                buildItem(holder, dao.getCocktails().get(position));
            }
        }
        //non empty research filter
        else {
            if (isShowAlcoholics) {
                int count = 0;
                for (Cocktail e : dao.getAlcoholicCocktails()) {
                    String nome = dao.getCocktail((e.getId())).getName();

                    if (nome.contains(this.researchFilter)) {
                        if (count == position) {
                            Cocktail el = dao.getCocktail((e.getId()));
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            } else if (isShowAnalcoholics) {
                int count = 0;
                for (Cocktail e : dao.getAnalcoholicCocktails()) {
                    String nome = dao.getCocktail((e.getId())).getName();

                    if (nome.contains(this.researchFilter)) {
                        if (count == position) {
                            Cocktail el = dao.getCocktail((e.getId()));
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            } else if (isShowPreferred) {
                int count = 0;
                for (Cocktail e : dao.getSavedCocktails()) {
                    String nome = dao.getCocktail((e.getId())).getName();

                    if (nome.contains(this.researchFilter)) {
                        if (count == position) {
                            Cocktail el = dao.getCocktail((e.getId()));
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            } else {
                int count = 0;
                for (Cocktail e : dao.getCocktails()) {
                    String nome = dao.getCocktail((e.getId())).getName();
                    if (nome.contains(this.researchFilter)) {
                        if (count == position) {
                            Cocktail el = dao.getCocktail((e.getId()));
                            buildItem(holder, el);
                        }
                        count++;
                    }
                }
            }
        }
    }

    /**
     * Method to build an item to put on the RecyclerView called by OnBindViewHolder
     * @param holder : the ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param cocktail: the cocktail to be put into the Recycle view
     */

    private void buildItem(@NonNull CocktailManager holder, Cocktail cocktail) {

        System.out.println("I have the cocktail:" + cocktail.getName());
        holder.cocktailName.setText(cocktail.getName());


        holder.cocktailImage.setImageResource(CocktailUtils.getCocktailImage(cocktail.getCategory()));
        holder.cocktailRow.setOnClickListener(view -> {
            Intent intent = new Intent(parent, CocktailActivity.class);
            intent.putExtra("name", cocktail.getName());
            intent.putExtra("category", cocktail.getCategory().toString());
            intent.putExtra("time", cocktail.getTime());
            intent.putExtra("saved", cocktail.getSaved());
            intent.putStringArrayListExtra("ingredients", (ArrayList<String>) cocktail.getIngredients());
            intent.putStringArrayListExtra("preparation", (ArrayList<String>) cocktail.getPreparation());

            parent.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (this.researchFilter.isEmpty()) {
            if (this.isShowAnalcoholics) {
                return this.dao.countAnalcoholicCocktails();
            } else if (this.isShowAlcoholics) {
                return this.dao.countAlcoholicCocktails();
            } else if (this.isShowPreferred) {
                return this.dao.countSavedCocktails();
            } else {
                return this.dao.countCocktails();
            }
        }
        if (this.isShowAlcoholics) {
            int count = 0;
            for (Cocktail e : dao.getAlcoholicCocktails()) {
                String nome = dao.getCocktail((e.getId())).getName();
                if (nome.contains(this.researchFilter)) {

                    count++;
                }
            }
            return count;
        }
        if (this.isShowAnalcoholics) {
            int count = 0;
            for (Cocktail e : dao.getAnalcoholicCocktails()) {
                String nome = dao.getCocktail((e.getId())).getName();
                if (nome.contains(this.researchFilter)) {

                    count++;
                }
            }
            return count;
        }
        if (this.isShowPreferred) {
            int count = 0;
            for (Cocktail e : dao.getSavedCocktails()) {
                String nome = dao.getCocktail((e.getId())).getName();
                if (nome.contains(this.researchFilter)) {

                    count++;
                }
            }
            return count;
        }
        int count = 0;
        for (Cocktail e : dao.getCocktails()) {
            String nome = dao.getCocktail((e.getId())).getName();
            if (nome.contains(this.researchFilter)) {

                count++;
            }
        }
        return count;
    }

    public static class CocktailManager extends RecyclerView.ViewHolder {

        private final LinearLayout cocktailRow;
        private final TextView cocktailName;
        private final ImageView cocktailImage;

        /**
         * Gets name, row and image from the view
         * @param view: view passed from OnCreateViewHolder
         */
        public CocktailManager(@NonNull View view) {
            super(view);

            cocktailName = view.findViewById(R.id.cocktail_name);
            cocktailRow = view.findViewById(R.id.cocktail_row);
            cocktailImage = view.findViewById(R.id.cocktail_image);
        }
    }


}