package com.movil.pixelcode.lostwords.Models;

import com.movil.pixelcode.lostwords.Models.Interfaces.ChooseGameEvent;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class Level
{
    private int Level;
    private int CorrectAccumulated;
    private TimerGame timer;
    private Word.DIFFICULTY_LEVEL Hardness;
    private Word.CATEGORY Category;
    private ContextGame game;
    private ChooseGameEvent event;

    public Level(Word.CATEGORY Category, ChooseGameEvent event) {
        Level = 1;
        CorrectAccumulated = 0;
        Hardness = Word.DIFFICULTY_LEVEL.EASY;
        this.Category = Category;
        this.event = event;
        game = new ContextGame(Category, 1);
    }

    public int getLevel() {
        return Level;
    }

    public TimerGame getTimer() {
        return timer;
    }

    public void setTimer(TimerGame timer) {
        this.timer = timer;
    }

    public ContextGame getGame() {
        return game;
    }

    public void IncreaseLevel() {

    }
}
