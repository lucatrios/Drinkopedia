package com.example.progetto_OOP.utils;

import com.example.progetto_OOP.R;
import com.example.progetto_OOP.db.Cocktail;

public class CocktailUtils {

    /**
     * Get an image (alcoholic, analcoholic) from the category of the cocktail.
     * @param category: category of the cocktail.
     * @return
     */
    public static int getCocktailImage(Cocktail.Category category){
        switch (category) {
            case Alcolico:
                return R.drawable.alcoholic;
            case Analcolico:
                return R.drawable.analcoholic;
            default:
                return 0;
        }
    }

    /**
     * Get an image (alcoholic, analcoholic) from the strinCategory of the cocktail.
     * @param stringCategory: category of the cocktail, as a string.
     * @return
     */
    public static int getCocktailImage(String stringCategory) {
        Cocktail.Category category = Cocktail.Category.valueOf(stringCategory);
        return getCocktailImage(category);
    }
}
