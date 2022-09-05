package com.example.progetto_OOP.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

/**
 * Class that represents the entity of the database, each attribute represents each column of the database.
 * The id is the primary key
 * Other attributes are 'non null' values.
 * saved = 1 to put a cocktail into preferred, saved = 0 to remove it.
 */
@Entity
public final class Cocktail {
    @PrimaryKey
    private final Integer id;
    @NonNull
    private final String name;
    @NonNull
    private final List<String> ingredients;
    /**
     * Time in minutes required to prepare the cocktail
     */
    @NonNull
    private final Integer time;
    @NonNull
    private final Category category;
    @NonNull
    private final List<String> preparation;
    @ColumnInfo(defaultValue = "0")
    private Integer saved; // FIXME: favorite

    public Cocktail(Integer id, @NonNull String name, @NonNull List<String> ingredients, @NonNull Integer time, @NonNull Category category, @NonNull List<String> preparation) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.time = time;
        this.category = category;
        this.preparation = preparation;
        this.saved = 0;
    }

    public Integer getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public List<String> getIngredients() {
        return ingredients;
    }

    @NonNull
    public Integer getTime() {
        return time;
    }

    @NonNull
    public Category getCategory() {
        return category;
    }

    @NonNull
    public List<String> getPreparation() {
        return preparation;
    }

    public int getSaved() {
        return this.saved;
    } // FIXME: isFavorite

    public void setSaved(Integer isSaved) {
        this.saved = isSaved;
    } // FIXME: setFavorite

    public enum Category {
        Alcolico, Analcolico
    }
}
