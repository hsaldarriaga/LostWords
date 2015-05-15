package com.movil.pixelcode.lostwords.Models;

import com.movil.pixelcode.lostwords.Models.Abstracts.ChooseGame;
import com.movil.pixelcode.lostwords.Models.Interfaces.BonusTimerGameEvent;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class BonusTimerGame {

    private long MaxMillis;
    private long CurrentMills;
    private BonusTimerGameEvent event;
    public BonusTimerGame(long maxMillis, ChooseGame.BONUS Bonus, BonusTimerGameEvent event) {
        MaxMillis = maxMillis;
        CurrentMills = 0;
        this.event = event;
    }

    public long getCurrentMills() {
        return CurrentMills;
    }

    public long getMaxMillis() {
        return MaxMillis;
    }

    private synchronized void setCurrentMills(long currentMills) {
        CurrentMills = currentMills;
    }

    public void StartTimer() {

    }

    public void PauseTimer() {

    }

    public void FinishTimer() {

    }
}
