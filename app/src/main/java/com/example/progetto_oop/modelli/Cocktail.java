package com.example.progetto_oop.modelli;

import java.io.Serializable;

public class Cocktail implements Serializable, Comparable<Cocktail> {
    /**
     * cocktail's id
     */

    public final int id;

    /**
     * cocktail's name
     */

    public final String nome;

    /**
     * cocktail's cost
     */

    public final String cost;

    /**
     * ingredients
     */

    public final String ingredients;

    /**
     * difficulty
     */

    public final String difficulty;

    /**
     * time
     */
    public final String time;

    /**
     * The category
     */

    public final String category;

    /**
     * The preparation
     */

    public final String preparation;

    /**
     * The flag for save or unsaved recipe
     */

    public Boolean salvata;

    Cocktail(int id, String nome, String cost, String ingredients, String difficulty, String time,
             String category, String preparation, Boolean salvata) {
        this.id=id;
        this.nome=nome;
        this.cost=cost;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.time = time;
        this.category = category;
        this.preparation=preparation;
        this.salvata=salvata;

    }

    @Override
    public int compareTo(Cocktail cocktail) {
        if(this.id==cocktail.id)
            return 1;
        else
            return 0;
    }
}
