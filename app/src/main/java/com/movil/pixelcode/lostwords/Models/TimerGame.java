package com.movil.pixelcode.lostwords.Models;

import com.movil.pixelcode.lostwords.Models.Interfaces.TimerGameEvent;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class TimerGame {

    private long MaxMillis;
    private long CurrentMillis;
    private TimerGameEvent TimeEvent;

    public TimerGame(long maxMillis) {
        MaxMillis = maxMillis;
        CurrentMillis = 0;
        TimeEvent = null;
    }

    public long getCurrentMillis() {
        return CurrentMillis;
    }

    public synchronized void setCurrentMillis(long currentMillis) {
        CurrentMillis = currentMillis;
    }

    public long getMaxMillis() {
        return MaxMillis;
    }

    public void setMaxMillis(long maxMillis) {
        MaxMillis = maxMillis;
    }

    public void setTimeEvent(TimerGameEvent timeEvent) {
        TimeEvent = timeEvent;
    }

    public void StartTimer() {

    }

    public void PauseGame() {

    }

    public void FinishTimer() {

    }

}
