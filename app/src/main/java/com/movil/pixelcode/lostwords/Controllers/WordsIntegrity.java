package com.movil.pixelcode.lostwords.Controllers;

import android.app.Activity;
import android.widget.ProgressBar;

import com.movil.pixelcode.lostwords.Controllers.Interfaces.WordIntegrityEvent;

/**
 * Created by hass-pc on 01/05/2015.
 */
public class WordsIntegrity {

    private ProgressBar ProgrBar;
    private int progress = 0;
    private Activity act;
    public WordsIntegrity(ProgressBar progress, Activity act) {
        this.ProgrBar = progress;
        this.act = act;
    }
    public void Verify(final WordIntegrityEvent Event)
    {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress++;
                    act.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ProgrBar.setProgress(progress);
                        }
                    });
                }
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Event.Done(true);
                    }
                });
            }
        });
        hilo.start();
    }

    private boolean LoadData()
    {
        return true;
    }
}
