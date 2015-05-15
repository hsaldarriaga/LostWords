package com.movil.pixelcode.lostwords.Models;

import com.movil.pixelcode.lostwords.Models.Abstracts.ChooseGame;

import java.util.List;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class ContextGame extends ChooseGame {

    private Word.CATEGORY Category;


    public ContextGame(Word.CATEGORY category, int NumberOfIncorrectAnswer) {
        super();
        Category = category;
    }

    @Override
    public List<Word> getWords() {
        return null;
    }

    @Override
    public boolean IsCorrect(Word word) {
        return false;
    }

    @Override
    public void ModifyScore() {
        
    }
}
