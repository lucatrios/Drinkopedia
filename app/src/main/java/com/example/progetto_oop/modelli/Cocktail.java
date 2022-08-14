package com.example.progetto_oop.modelli;

import java.io.Serializable;

public class Cocktail implements Serializable, Comparable<Cocktail> {
    /**
     * id del drink da bere
     */

    public final int id;

    /**
     * Nome del drink
     */

    public final String nome;

    /**
     * costo del drink
     */

    public final String cost;

    /**
     * ingredienti
     */

    public final String ingredients;

    /**
     * difficoltà
     */

    public final String difficulty;

    /**
     * tempo
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
