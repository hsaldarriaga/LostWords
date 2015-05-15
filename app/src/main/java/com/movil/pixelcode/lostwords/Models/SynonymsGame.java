package com.movil.pixelcode.lostwords.Models;

import com.movil.pixelcode.lostwords.Models.Abstracts.ChooseGame;

import java.util.List;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class SynonymsGame extends ChooseGame {

    public SynonymsGame() {
        super();
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
    protected void ModifyScore() {

    }
}
