package com.movil.pixelcode.lostwords.Views.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.movil.pixelcode.lostwords.R;
import com.movil.pixelcode.lostwords.Views.Animations.StartGameAnimation;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartGameFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.f_start_game, container, false);
        animation = new StartGameAnimation(getActivity());
        mPlayer = MediaPlayer.create(this.getActivity(), R.raw.intro_milkyway);
        mPlayer.setLooping(true);
        mPlayer.start();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPlayer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPlayer.pause();
    }

    @Override
    public void onDestroy() {
        animation.OnDestroy();
        mPlayer.stop();
        mPlayer.release();
        super.onDestroy();
    }

    private StartGameAnimation animation;
    private MediaPlayer mPlayer;
}
