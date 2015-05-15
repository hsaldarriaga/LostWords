package com.movil.pixelcode.lostwords.Models.Abstracts;

import com.movil.pixelcode.lostwords.Models.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hass-pc on 01/05/2015.
 */
public abstract class ChooseGame {


    public enum BONUS { ANTONYMS, SYNONYMS};

    final List<Word> Words;

    protected ChooseGame() {
        Words = new ArrayList<>();
    }

    public abstract List<Word> getWords();

    public abstract boolean IsCorrect(Word word);

    protected abstract void ModifyScore();
}
