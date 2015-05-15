package com.movil.pixelcode.lostwords.Models;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class Word {

    public enum DIFFICULTY_LEVEL { EASY, MEDIUM, HARD};
    public enum CATEGORY { BEACH, CAMPING, CITY, DESERT, DIVERSION, NIGHT, SNOW, ZOO};

    private final int Id;
    private final String Name;
    private final DIFFICULTY_LEVEL Level;
    private final CATEGORY Category;

    public Word(int id, String name, DIFFICULTY_LEVEL level, CATEGORY category) {
        Id = id;
        Name = name;
        Level = level;
        Category = category;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public DIFFICULTY_LEVEL getLevel() {
        return Level;
    }

    public CATEGORY getCategory() {
        return Category;
    }
}
