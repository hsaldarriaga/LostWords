package com.movil.pixelcode.lostwords.Views.Listener;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;

import com.movil.pixelcode.lostwords.R;

/**
 * Created by hass-pc on 13/05/2015.
 */
public class ImageSwitcherTouchListener implements View.OnTouchListener {

    private double x_inicial = 0;
    private int index = 0;
    private Activity context;
    private View[] circles;
    private int[] Images;
    private ImageSwitcher switcher;
    private View Background_View;
    private Animation[] animations;
    public ImageSwitcherTouchListener(Activity context, View[] circles, int[] images, ImageSwitcher switcher, View background_View) {
        this.context = context;
        this.circles = circles;
        Images = images;
        this.switcher = switcher;
        Background_View = background_View;
        animations = new Animation[4];
        animations[0] = AnimationUtils.loadAnimation(context,
                R.anim.slide_in_right);
        animations[1] = AnimationUtils.loadAnimation(context,
                R.anim.slide_out_left);
        animations[2] = AnimationUtils.loadAnimation(context,
                android.R.anim.slide_in_left);
        animations[3] = AnimationUtils.loadAnimation(context,
                android.R.anim.slide_out_right);
        animations[0].setDuration(600);
        animations[1].setDuration(600);
        animations[2].setDuration(600);
        animations[3].setDuration(600);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            x_inicial = event.getX();
        }
        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            if (Math.abs(x_inicial - event.getX()) > 60) {
                if (x_inicial - event.getX() < 0) { //Izquierda
                    if (index == 0) {
                        context.finish();
                    } else {
                        previous();
                    }
                } else {
                    if (index == Images.length-1) {
                        context.finish();
                        //Seleccionar juego
                    } else {
                        next();
                    }
                }
            }
            x_inicial = 0;
            return true;
        }
        return true;
    }

    private void next(){
        int before = index;
        index+=1;
        switcher.setInAnimation(animations[0]);
        switcher.setOutAnimation(animations[1]);
        SetImage(before, index);
        SetPositionCircle();
    }
    private void previous(){
        int before = index;
        index-=1;
        switcher.setInAnimation(animations[2]);
        switcher.setOutAnimation(animations[3]);
        SetImage(before, index);
        SetPositionCircle();
    }

    private void SetPositionCircle()
    {
        for (int i = 0; i < 4; i++) {
            if (index == i) {
                circles[i].setBackgroundResource(R.drawable.circle_full);
            } else {
                circles[i].setBackgroundResource(R.drawable.circle_empty);
            }
        }
    }

    private void SetImage(int before, int i) {
        switcher.setImageResource(Images[i]);
        Integer colorFrom=0, colorTo=0;
        switch (i) {
            case 0:
                colorFrom = context.getResources().getColor(R.color.red);
                colorTo = context.getResources().getColor(R.color.blue);
                break;
            case 1:
                if (before > index) {
                    colorFrom = context.getResources().getColor(R.color.green);
                    colorTo = context.getResources().getColor(R.color.red);
                } else {
                    colorFrom = context.getResources().getColor(R.color.blue);
                    colorTo = context.getResources().getColor(R.color.red);
                }
                break;
            case 2:
                if (before > index) {
                    colorFrom = context.getResources().getColor(R.color.orange);
                    colorTo = context.getResources().getColor(R.color.green);
                } else {
                    colorFrom = context.getResources().getColor(R.color.red);
                    colorTo = context.getResources().getColor(R.color.green);
                }
                break;
            case 3:
                colorFrom = context.getResources().getColor(R.color.green);
                colorTo = context.getResources().getColor(R.color.orange);
                break;
        }
        ChangeColor(colorFrom, colorTo);
    }

    private void ChangeColor(int ColorFrom, int ColorTo)
    {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), ColorFrom, ColorTo);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                Background_View.setBackgroundColor((Integer)animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }
}
