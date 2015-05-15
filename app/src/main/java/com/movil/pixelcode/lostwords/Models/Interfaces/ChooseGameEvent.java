package com.movil.pixelcode.lostwords.Models.Interfaces;

import com.movil.pixelcode.lostwords.Models.AntonymsGame;
import com.movil.pixelcode.lostwords.Models.SynonymsGame;

/**
 * Created by hass-pc on 01/05/2015.
 */
public interface ChooseGameEvent {

    public void StartAntonymsGame(AntonymsGame game);

    public void StartSynonymsGame(SynonymsGame game);
}
