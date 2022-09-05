package com.example.progetto_OOP.db;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The following code defines a BarDatabase class to hold the database. BarDatabase defines the database configuration and serves as the app's main access point to the persisted data.
 * For each DAO class that is associated with the database, the database class must define an abstract method that has zero arguments and returns an instance of the DAO class.
 * The class includes a @TypeConverters StringListConverter that it's internally implemented into the database.
 * READING
 * Every time the converter finds a '@' character into a String it splits the String, each piece is collected into a List.
 * WRITING
 * When writing into database the List<String> is joined by the '@' character.
 */
@Database(entities = {Cocktail.class}, version = 2)
@TypeConverters({BarDatabase.StringListConverter.class})
public abstract class BarDatabase extends RoomDatabase {
    public abstract CocktailDao cocktailDao();

    static class StringListConverter {
        private static final String SEPARATOR = "@";

        @RequiresApi(api = Build.VERSION_CODES.N)
        @TypeConverter
        public static List<String> fromString(String stringListString) {
            return Arrays.stream(stringListString.split(SEPARATOR)).collect(Collectors.toList());
        }

        @TypeConverter
        public static String toString(List<String> stringList) {
            return String.join(SEPARATOR, stringList);
        }
    }
}
