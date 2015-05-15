package com.movil.pixelcode.lostwords.Views.Activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.movil.pixelcode.lostwords.R;
import com.movil.pixelcode.lostwords.Views.Fragments.StartGameFrag;


public class InitialScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.a_initial_screen);
    }

    public void LoadingDone() {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        StartGameFrag frag = new StartGameFrag();
        trans.replace(R.id.InitialContainer, frag).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    public void StartGame(View v)
    {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }

    public void HowToPlay(View v)
    {
        Intent intent = new Intent(this, HowToScreen.class);
        startActivity(intent);
    }
}
