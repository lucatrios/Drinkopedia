package com.example.progetto_OOP.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progetto_OOP.R;
import com.example.progetto_OOP.db.BarDatabase;
import com.google.android.material.textfield.TextInputEditText;

public final class CocktailList extends Fragment {

    // new variables
    private final BarDatabase db;
    private RecyclerView cocktailList;
    private CocktailListManager cocktailListManager;
    private TextInputEditText researchInput;

    public CocktailList(BarDatabase db) {
        this.db = db;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cocktail_list, container, false);

        cocktailList = view.findViewById(R.id.cocktailList);
        cocktailList.setHasFixedSize(true);
        cocktailList.setLayoutManager(new LinearLayoutManager(view.getContext()));

        researchInput = view.findViewById(R.id.research_input);
        Activity activity = this.getActivity();
        researchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cocktailListManager = new CocktailListManager(activity, s.toString(), db.cocktailDao(), view.findViewById(R.id.showAlcoholics), view.findViewById(R.id.showAnalcoholics), view.findViewById((R.id.Preferred)));
                cocktailList.setAdapter(cocktailListManager);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        cocktailListManager = new CocktailListManager(activity, "", db.cocktailDao(), view.findViewById(R.id.showAlcoholics), view.findViewById(R.id.showAnalcoholics), view.findViewById((R.id.Preferred)));
        cocktailList.setAdapter(cocktailListManager);
        return view;

    }
}
