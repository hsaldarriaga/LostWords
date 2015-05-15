package com.movil.pixelcode.lostwords.Views.Activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.movil.pixelcode.lostwords.R;
import com.movil.pixelcode.lostwords.Views.Listener.ImageSwitcherTouchListener;

/**
 * Created by hass-pc on 13/05/2015.
 */
public class HowToScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_how_to_screen);
        switcher = (ImageSwitcher)findViewById(R.id.how_ImageSwitcher);
        circles = new View[4];
        circles[0] = findViewById(R.id.circle_1);
        circles[1] = findViewById(R.id.circle_2);
        circles[2] = findViewById(R.id.circle_3);
        circles[3] = findViewById(R.id.circle_4);
        View_Background = findViewById(R.id.how_background);
        Images = new int[4];
        Images[0] = R.drawable.how_01;
        Images[1] = R.drawable.how_02;
        Images[2] = R.drawable.how_03;
        Images[3] = R.drawable.how_04;
        Initialize();
    }

    private void Initialize()
    {
        final Context this_context = this;
        switcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                ImageView myView = new ImageView(this_context);
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.
                        MATCH_PARENT, ImageSwitcher.LayoutParams.MATCH_PARENT));
                return myView;
            }
        });
        switcher.setImageResource(R.drawable.how_01);
        switcher.setOnTouchListener(new ImageSwitcherTouchListener(this, circles, Images, switcher, View_Background));
    }

    private ImageSwitcher switcher;
    private View[] circles;
    private View View_Background;
    private int[] Images;
}
