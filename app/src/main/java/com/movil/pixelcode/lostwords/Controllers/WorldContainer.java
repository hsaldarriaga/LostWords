package com.movil.pixelcode.lostwords.Controllers;

import android.content.Context;

import com.movil.pixelcode.lostwords.Models.Word;

import java.util.List;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class WorldContainer {
    private static WorldContainer ourInstance;

    public static WorldContainer getInstance() {
        return ourInstance;
    }
    static void Initialize(Context c) {
        ourInstance = new WorldContainer(c);
    }

    private WorldContainer(Context c) {
    }

    public List<Word> getContextWords(Word.CATEGORY cat, Word.DIFFICULTY_LEVEL level, int n, int Incorrect) {
        return null;
    }

    public List<Word> getSynonyms(int n, int Incorrect) {
        return null;
    }

    public List<Word> getAntonyms(int n, int Incorrect) {
        return null;
    }
}
