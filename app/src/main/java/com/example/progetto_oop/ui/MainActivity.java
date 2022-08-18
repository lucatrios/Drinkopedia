package com.example.progetto_oop.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.che_cosa_preparo.R;
import com.example.che_cosa_preparo.modelli.Ricettario;
import com.example.che_cosa_preparo.ui.main.ListaElementiFragment;
import com.example.progetto_oop.modelli.Menu;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Menu.setup(this);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ListaElementiFragment.newInstance())
                    .commitNow();
        }

    }
}
