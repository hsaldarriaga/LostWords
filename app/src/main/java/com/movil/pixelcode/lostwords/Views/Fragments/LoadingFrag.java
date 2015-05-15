package com.movil.pixelcode.lostwords.Views.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.movil.pixelcode.lostwords.Controllers.Interfaces.WordIntegrityEvent;
import com.movil.pixelcode.lostwords.Controllers.WordsIntegrity;
import com.movil.pixelcode.lostwords.R;
import com.movil.pixelcode.lostwords.Views.Activities.InitialScreen;

/**
 * Created by hass-pc on 28/04/2015.
 */
public class LoadingFrag extends Fragment implements WordIntegrityEvent {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_loading_frag, container, false);

        ProgrBar = (ProgressBar)v.findViewById(R.id.ProgressBLoading);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Paused = false;
        if (!Executed) {
            WordsIntegrity integrity = new WordsIntegrity(ProgrBar, getActivity());
            integrity.Verify(this);
        } else {
            if (ProgrBar.getProgress() == ProgrBar.getMax()) {
                if (Verified) {
                    ((InitialScreen) getActivity()).LoadingDone();
                } else {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                    getActivity().finish();
                }
            }
        }
    }

    @Override
    public void onPause() {
        Paused = true;
        super.onPause();
    }

    @Override
    public void Done(boolean state) {
        Executed = true;
        if (state) {
            Verified = true;
            if (!Paused) {
                ((InitialScreen)getActivity()).LoadingDone();
            }
        } else {
            if (!Paused) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        }
    }

    private ProgressBar ProgrBar;
    private boolean Verified = false, Executed = false, Paused = false;
}
