package com.movil.pixelcode.lostwords.Models.Abstracts;

/**
 * Created by hass-pc on 01/05/2015.
 */
public abstract class Score {
    protected long Score;

    protected  Score(long Score) {
        this.Score = Score;
    }

    public long getScore() {
        return Score;
    }

    public void AddToScore(long value) {
        Score = value;
    }
}
