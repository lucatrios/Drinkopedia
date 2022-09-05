package com.example.progetto_OOP.ui;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.progetto_OOP.R;
import com.example.progetto_OOP.db.BarDatabase;
import com.example.progetto_OOP.db.Cocktail;
import com.example.progetto_OOP.db.CocktailDao;
import com.example.progetto_OOP.utils.CocktailUtils;

import java.util.List;

/**
 * Class that extends AppCompatActivity
 */
public final class CocktailActivity extends AppCompatActivity {

    private ImageButton saved;
    private CocktailDao dao;
    private Cocktail cocktail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocktail_activity);
        saved = findViewById(R.id.saved);

        /**
         * Instantiation of the prepopulated database from the assets folder
         */
        BarDatabase db = Room
                .databaseBuilder(getApplicationContext(), BarDatabase.class, "bar.db")
                .enableMultiInstanceInvalidation()
                .createFromAsset("databases/bar.db")
                .allowMainThreadQueries()
                .build();
        dao = db.cocktailDao();

        Bundle b = getIntent().getExtras();
        if (b != null) {
            String name = b.getString("name");
            String category = b.getString("category");
            String difficulty = b.getString("difficulty");
            int timeInMinutes = b.getInt("time");
            List<String> ingredients = b.getStringArrayList("ingredients");
            List<String> preparation = b.getStringArrayList("preparation");
            String cocktailName = b.getString("name");
            int id = dao.getIdFromName(cocktailName);
            cocktail = dao.getCocktail(id);

            /**
             * When a cocktail is clicked for the first time the star is set on or off whether the cocktail has been put to preferred or not
             */
            if (cocktail.getSaved() == 1) {
                saved.setImageResource(android.R.drawable.star_big_on);
            } else {
                saved.setImageResource(android.R.drawable.star_big_off);
            }

            ((ImageView) findViewById(R.id.cocktail_image)).setImageResource(CocktailUtils.getCocktailImage(category));
            ((TextView) findViewById(R.id.cocktail_name)).setText(name);
            ((TextView) findViewById(R.id.cocktail_value)).setText(category);
            ((TextView) findViewById(R.id.time_value)).setText(timeInMinutes == 1 ? String.format("%s minuto", timeInMinutes) : String.format("%s minuti", timeInMinutes));
            ((TextView) findViewById(R.id.ingredients_value)).setText(String.join(System.lineSeparator(), ingredients));
            ((TextView) findViewById(R.id.preparation)).setText(String.format("PREPARAZIONE %s %s", System.lineSeparator(), String.join(System.lineSeparator(), preparation)));

            /**
             * When the saved button is clicked the state of the cocktail is updated, as well as the drawable object that represents whether the cocktail has ben put into preferred or not
             */
            saved.setOnClickListener(view -> {
                cocktail = dao.getCocktail(id);
                if (cocktail.getSaved() == 0) {
                    saved.setImageResource(android.R.drawable.star_big_on);
                    dao.updateCocktail(1, id);
                }

                if (cocktail.getSaved() == 1) {
                    saved.setImageResource(android.R.drawable.star_big_off);
                    dao.updateCocktail(0, id);
                }
            });
        }
    }
}
