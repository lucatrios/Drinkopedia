package com.example.progetto_OOP.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.progetto_OOP.R;
import com.example.progetto_OOP.db.BarDatabase;
import com.example.progetto_OOP.ui.CocktailList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Instantiation of the prepopulated database from the assets folder
         */
        BarDatabase db =  Room
                .databaseBuilder(getApplicationContext(), BarDatabase.class, "bar.db")
                .enableMultiInstanceInvalidation()
                .createFromAsset("databases/bar.db")
                .allowMainThreadQueries()
                .build();

        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new CocktailList(db))
                    .commitNow();
        }
    }
}
