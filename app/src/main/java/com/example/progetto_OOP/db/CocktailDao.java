package com.example.progetto_OOP.db;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

/**
 * Data access object for the database.
 * It defines all the queries executed into the database.
 * Each query is annotated with @Query and must contain a String for the query and the definition of a method that will be automatically implemented during the building.
 */

@Dao
public interface CocktailDao {

    /**
     * Query to get a cocktail from the id
     * @param id: the id of the cocktail to be selected
     * @return: a cocktail object
     */

    @Query("SELECT * FROM cocktail WHERE id=:id")
    Cocktail getCocktail(Integer id);

    /**
     * Query to get the id from name.
     * @param name: name of the cocktail
     * @return: the id of the cocktail with that name
     */

    @Query("SELECT id FROM cocktail where name = :name")
    int getIdFromName(String name);

    /**
     * Query to get the whole table cocktail ordered by id
     * @return: a List<Cocktail> created with the help of @TypeConverters
     */

    @Query("SELECT * FROM cocktail ORDER BY ID")
    List<Cocktail> getCocktails();

    /**
     * Query to get only analcoholic cocktails ordered by id
     * @return: a List<Cocktail> created with the help of @TypeConverters
     */

    @Query("SELECT * FROM cocktail WHERE category='Analcolico' ORDER BY ID")
    List<Cocktail> getAnalcoholicCocktails();

    /**
     * Query to get only alcoholic cocktails ordered by id
     * @return: a List<Cocktail> created with the help of @TypeConverters
     */

    @Query("SELECT * FROM cocktail WHERE category='Alcolico' ORDER BY ID")
    List<Cocktail> getAlcoholicCocktails();

    /**
     * Query to get only preferred cocktails ordered by id
     * @return: a List<Cocktail> created with the help of @TypeConverters
     */

    @Query("SELECT * FROM cocktail WHERE saved=1 ORDER BY ID")
    List<Cocktail> getSavedCocktails();

    /**
     * Query to get the count of cocktails stored into the database
     * @return: an int that represents the number of cocktails counted
     */

    @Query("SELECT COUNT(*) FROM cocktail")
    int countCocktails();

    /**
     * Query to get the count of analcoholic cocktails stored into the database
     * @return: an int that represents the number of cocktails counted
     */

    @Query("SELECT COUNT(*) FROM cocktail WHERE category='Analcolico'")
    int countAnalcoholicCocktails();

    /**
     * Query to get the count of alcoholic cocktails stored into the database
     * @return: an int that represents the number of cocktails counted
     */

    @Query("SELECT COUNT(*) FROM cocktail WHERE category='Alcolico'")
    int countAlcoholicCocktails();

    /**
     * Query to get the count of preferred cocktails stored into the database
     * @return: an int that represents the number of cocktails counted
     */

    @Query("SELECT COUNT(*) FROM cocktail WHERE saved=1")
    int countSavedCocktails();

    /**
     * Query to update the database when a cocktail is set to preferred
     * @param value: can be 1 or 0 depending whether the cocktail has been set preferred or not
     * @param id: the id of the cocktail that has to be updated.
     */
    @Query("UPDATE cocktail SET saved= :value WHERE id= :id")
    void updateCocktail(int value, int id);

}
