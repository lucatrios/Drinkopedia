package com.example.progetto_oop.ui.ingredients;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.che_cosa_preparo.R;
import com.example.che_cosa_preparo.modelli.Ricettario;
import com.example.che_cosa_preparo.modelli.Ricetta;
import com.example.che_cosa_preparo.ui.main.ConnectionDB;
import com.example.progetto_oop.modelli.Cocktail;
import com.example.progetto_oop.modelli.Menu;


import java.util.Locale;

public class ElementoActivity extends AppCompatActivity {

    private ImageButton salva;
    private ConnectionDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento);


        salva= findViewById(R.id.salva);
        db= new ConnectionDB(this);


        Bundle b = getIntent().getExtras();
        int numero;
        if (b != null) {



            numero = b.getInt("numero");
            Cocktail cocktail = Menu.getCocktail(numero);

            for(int i=0;i<db.getNumeroCocktailSalvati();i++)
            {
                if(cocktail.id==db.getCocktailSalvati()[i])
                    cocktail.salvata=true;
            }

/* controllo di cocktail.salvata*/

            if(cocktail.salvata){
                salva.setImageResource(android.R.drawable.star_big_on);
            }
            else{
                salva.setImageResource(android.R.drawable.star_big_off);
            }

            ((ImageView) findViewById(R.id.immagine_Cocktail)).setImageResource(Menu.getImageCocktail(cocktail));

            ((TextView) findViewById(R.id.nome_Cocktail)).setText(Menu.getCocktailName(cocktail.id));

            ((TextView) findViewById(R.id.Cocktail_value)).setText(cocktail.category);

            ((TextView) findViewById(R.id.difficulty_value)).setText(cocktail.difficulty);

            ((TextView) findViewById(R.id.time_value)).setText(cocktail.time);

            ((TextView) findViewById(R.id.ingredients_value)).setText(cocktail.ingredients);

            ((TextView) findViewById(R.id.preparazione)).setText("PREPARAZIONE\n" + cocktail.preparation);





            salva.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view){

                    int numero;
                    numero = b.getInt("numero");
                    Cocktail elemento = Menu.getCocktail(numero);

                    if(!elemento.salvata){
                        salva.setImageResource(android.R.drawable.star_big_on);
                        db.addRecord(elemento.id, elemento.nome);
                    }

                    if(elemento.salvata)
                    {
                        salva.setImageResource(android.R.drawable.star_big_off);
                        db.removeRecord(elemento.id, elemento.nome);
                    }
                    elemento.setSalvata(!elemento.salvata);

                }

            });




        }
    }
}
